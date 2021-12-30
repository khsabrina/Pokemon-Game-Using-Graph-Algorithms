package ex4_java_client.elements;

public class Pokemon {
        private double value;
        private int type;
        private geoLocation pos;
        private Edge edge;
        private Boolean assign;

        public Pokemon(double value, int type, geoLocation pos, Edge edge){
                this.value =value;
                this.type = type;
                this.pos = pos;
                this.edge =edge;
                this.assign = false;
        }

        public double getValue(){
                return this.value;
        }

        public int getType(){
                return this.type;
        }
        public geoLocation getLocation(){
                return this.pos;
        }
        public Edge getEdge(){
                return this.edge;
        }

        public Boolean equals(Pokemon pokemon){
                return (this.value==pokemon.getValue() && this.pos.x() == pokemon.pos.x() && this.edge.getSrc() == pokemon.edge.getSrc() && this.type==pokemon.type);
        }

        public Boolean getAssign() {
                return assign;
        }

        public void setAssign(Boolean assign) {
                this.assign = assign;
        }
}
