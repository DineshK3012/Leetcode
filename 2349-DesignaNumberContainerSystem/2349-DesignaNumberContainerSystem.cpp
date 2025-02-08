class NumberContainers {
    unordered_map<int, int> inmap;
    unordered_map<int, set<int>> nimap;

public:
    NumberContainers() {
        //do nothing
    }
    
    void change(int index, int number) {
        if(inmap.find(index) != inmap.end()){
            //removing the previous number for the index
            int prev = inmap[index];
            nimap[prev].erase(index);

            if(nimap[prev].size() == 0){
                nimap.erase(prev);
            }
        }
        
        //putting the new number at the index
        inmap[index] = number;
        nimap[number].insert(index);
    }
    
    int find(int number) {
        if(nimap.find(number) != nimap.end()){
            return *nimap[number].begin();
        }

        return -1;
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */