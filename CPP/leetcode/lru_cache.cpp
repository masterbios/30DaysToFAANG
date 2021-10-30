class LRUCache {
    int capacity;
    list < int > dq;
    unordered_map < int, list < int > :: iterator > mp;
    unordered_map < int, int > mp_value;
public:
    LRUCache(int c) {
        capacity = c;
    }

    int get(int key) {
        if(mp.find(key) == mp.end()) {
            return -1;
        }
        dq.erase(mp[key]);
        dq.push_front(key);
        mp[key] = dq.begin();
        return mp_value[key];
    }

    void put(int key, int value) {
        // cout << capacity << "\n";
        if(mp.find(key) == mp.end()) {
            if(dq.size() == capacity) {
                mp_value.erase(dq.back());
                mp.erase(dq.back());
                dq.pop_back();
            }
        } else {
            dq.erase(mp[key]);
        }
        dq.push_front(key);
        mp[key] = dq.begin();
        mp_value[key] = value;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

