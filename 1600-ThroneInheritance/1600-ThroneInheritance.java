class ThroneInheritance {
    private Person king;
    private final Map<String, Person> persons;

    public ThroneInheritance(final String kingName) {
        this.king = new Person(kingName);

        this.persons = new HashMap<>();

        this.persons.put(kingName, this.king);
    }
    
    public void birth(final String parentName, final String childName) {
        final Person child = new Person(childName);

        this.persons.get(parentName).children().add(child);
        this.persons.put(childName, child);
    }
    
    public void death(final String name) {
        this.persons.get(name).isAlive(false);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();

        this.dfs(this.king, result);

        return result;
    }

    private void dfs(Person king, List<String> result) {
        if(king != null) {
            if(king.isAlive())
                result.add(king.name());

            for(Person child : king.children())
                dfs(child, result);
        }
    }

    private final class Person {
        private final String name;
        private final List<Person> children;
        private boolean isAlive;

        public Person(final String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isAlive = true;
        }

        public String name() {
            return this.name;
        }

        public List<Person> children() {
            return this.children;
        }

        public boolean isAlive() {
            return this.isAlive;
        }

        public void isAlive(final boolean isAlive) {
            this.isAlive = isAlive;
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */



/*import java.util.ArrayList;
import java.util.HashMap;

class ThroneInheritance {
    private final FamilyTree familyTree;

    public ThroneInheritance(String kingName) {
        familyTree = new FamilyTree(kingName);
    }
    
    public void birth(String parentName, String childName) {
        familyTree.birth(parentName, childName);
    }
    
    public void death(String name) {
        familyTree.death(name);
    }
    
    public List<String> getInheritanceOrder() {
        return familyTree.getInheritanceOrder();
    }
}

class FamilyTree {
    private final FamilyNode king;
    private final HashMap<String, FamilyNode> nameToNode;
    
    public FamilyTree(String kingName) {
        this.king = new FamilyNode(kingName);
        nameToNode = new HashMap<>();
        nameToNode.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        // based on what the Exersice said, this should NEVER return null, so no need to check
        FamilyNode parent = nameToNode.get(parentName);
        FamilyNode child = new FamilyNode(childName);

        parent.addChild(child);
        nameToNode.put(childName, child);
        
    }

    public void death(String name) {
        FamilyNode node = nameToNode.get(name);
        node.kill();
    }

    public List<String> getInheritanceOrder() {
        return king.getInheritanceOrder();
    }

    class FamilyNode {
        private final String name;
        private boolean alive;
        private final ArrayList<FamilyNode> children;

        public FamilyNode(String name) {
            this(name, true);
        }

        public FamilyNode(String name, boolean alive) {
            this.name = name;
            this.alive = alive;
            this.children = new ArrayList<>();
        }

        public String getName() {
            return this.name;
        }

        public boolean isAlive() {
            return this.alive;
        }

        public ArrayList<FamilyNode> getChildren() {
            return this.children;
        }

        public void kill() {
            this.alive = false;
        }

        public void addChild(String childName) {
            addChild(new FamilyNode(childName));
        }

        public void addChild(FamilyNode child) {
            children.add(child);
        }


        public List<String> getInheritanceOrder() {
            ArrayList<String> inheritOrder = new ArrayList<>();
            if(isAlive()) {
                inheritOrder.add(getName());
            }

            for(FamilyNode familyNode:getChildren()) {
                inheritOrder.addAll(familyNode.getInheritanceOrder());
            }

            return inheritOrder;
        }
    }
}


/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */