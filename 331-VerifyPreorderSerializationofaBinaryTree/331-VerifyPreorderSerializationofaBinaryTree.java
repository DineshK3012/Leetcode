class Solution {
    public boolean checkSubtree(String[] nodes, int[] counter){
        if(counter[0] >= nodes.length){
            return false;
        }

        if(nodes[counter[0]].equals("#")){
            return true;
        }

        // System.out.println(nodes[counter[0]] + " " + counter[0]);

        counter[0]++;
        boolean left = checkSubtree(nodes, counter);
        if(!left){
            return false;
        }

        counter[0]++;
        boolean right = checkSubtree(nodes, counter);
       
        return right;
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int[] counter = new int[1];
        boolean res = checkSubtree(nodes, counter);
        System.out.println(res + " " + counter[0]);
        return res && (counter[0] == nodes.length-1);
    }
}