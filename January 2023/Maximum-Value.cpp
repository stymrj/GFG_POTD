class Solution {
  public:
    vector<int> maximumValue(Node* node) {
       //level order traversal 
       vector<int>ans;
        queue<Node*>q;//stores nodes
        if(node==NULL){
            return ans; //i.e empty
        }
        //else insert root  in queue
        q.push(node);

        while(!q.empty()){
            int val = -1;
            int size_to_traverse = q.size();//traversing till size of each level

            for(int i=0;i<size_to_traverse;i++){
                //see if left and right exist if yes take that that node in queue
                 Node*root = q.front();
                q.pop();//remove from queue 
                if(root->left!=NULL){
                    q.push(root->left);
                }
                if(root->right!=NULL){
                    q.push(root->right);
                }
            //now,see for max nodes in all level  
            val=max(val,root->data);
            }
       //store val in ans now  
       ans.push_back(val);
        } 
        return ans;
    }
};
