class Solution {
        Node * merge(Node * a, Node * b) {
            Node * result = new Node(0);
            Node * temp = result;

            while(a and b) {
                if(a -> data < b -> data) {
                    temp -> bottom = a;
                    temp = temp -> bottom;
                    a = a -> bottom;
                } else {
                    temp -> bottom = b;
                    temp = temp -> bottom;
                    b = b -> bottom;
                }
            }

            temp -> bottom = a ? a: b;
            return result -> bottom;
        }

        Node *flatten(Node *root)
        {
           if(!root or !root -> next) {
               return root;
           }
           return merge(root, flatten(root -> next));
        }
}

