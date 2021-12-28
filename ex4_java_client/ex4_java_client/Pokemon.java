package ex4_java_client.ex4_java_client;

public class Pokemon {
        double value;
        int type;
        GeoLocation pos;
        Edge edge;

        public Pokemon(double value,int type,GeoLocation pos,Edge egde){
                this.value =value;
                this.type = type;
                this.pos = pos;
                this.edge =egde;
        }

        public double GetValue(){
                return this.value;
        }

        public int GetType(){
                return this.type;
        }
        public GeoLocation GetLocation(){
                return this.pos;
        }
        public Edge GetEdge(){
                return this.edge;
        }


}
