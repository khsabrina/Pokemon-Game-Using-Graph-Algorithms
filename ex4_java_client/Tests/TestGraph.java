//package ex4_java_client.Tests;
//import ex4_java_client.elements.Edge;
//import ex4_java_client.elements.Graph;
//import ex4_java_client.elements.Node;
//import ex4_java_client.elements.geoLocation;
//import org.junit.jupiter.api.Test;
//
//import java.util.Iterator;
//
//import static org.junit.jupiter.api.Assertions.*;
//public class TestGraph {
//    Graph gr = new Graph("{\"Edges\":[{\"src\":0,\"w\":1.3118716362419698,\"dest\":16},{\"src\":0,\"w\":1.232037506070033,\"dest\":1},{\"src\":0,\"w\":0.915443564766393,\"dest\":21},{\"src\":1,\"w\":1.8635670623870366,\"dest\":0},{\"src\":1,\"w\":1.8015954015822042,\"dest\":2},{\"src\":1,\"w\":1.2579255647223926,\"dest\":26},{\"src\":2,\"w\":1.5784991011275615,\"dest\":1},{\"src\":2,\"w\":1.0631605142699874,\"dest\":3},{\"src\":2,\"w\":1.7938753352369698,\"dest\":6},{\"src\":3,\"w\":1.440561778177153,\"dest\":2},{\"src\":3,\"w\":1.2539385028794277,\"dest\":4},{\"src\":4,\"w\":1.8418222744214585,\"dest\":3},{\"src\":4,\"w\":1.1422264879958028,\"dest\":5},{\"src\":4,\"w\":1.1730460536148573,\"dest\":28},{\"src\":5,\"w\":1.5855912911662344,\"dest\":4},{\"src\":5,\"w\":1.734311926030133,\"dest\":6},{\"src\":5,\"w\":1.1029613695942861,\"dest\":28},{\"src\":6,\"w\":1.8474047229605628,\"dest\":2},{\"src\":6,\"w\":1.4964304236123005,\"dest\":5},{\"src\":6,\"w\":1.237565124536135,\"dest\":7},{\"src\":7,\"w\":1.5786081900467002,\"dest\":6},{\"src\":7,\"w\":1.3717352984705653,\"dest\":8},{\"src\":7,\"w\":1.0687354408357501,\"dest\":27},{\"src\":8,\"w\":1.2817370911337442,\"dest\":7},{\"src\":8,\"w\":1.5328553219807337,\"dest\":9},{\"src\":8,\"w\":1.025149439083266,\"dest\":25},{\"src\":8,\"w\":1.2039873817393092,\"dest\":26},{\"src\":9,\"w\":1.0350683385093797,\"dest\":23},{\"src\":9,\"w\":1.9855087252581762,\"dest\":8},{\"src\":9,\"w\":1.2861739185896588,\"dest\":10},{\"src\":10,\"w\":1.5815006562559664,\"dest\":9},{\"src\":10,\"w\":1.4962204797190428,\"dest\":11},{\"src\":11,\"w\":1.2330298625884384,\"dest\":20},{\"src\":11,\"w\":1.3784147388591739,\"dest\":10},{\"src\":11,\"w\":1.9316059913913906,\"dest\":12},{\"src\":12,\"w\":1.0666986438224981,\"dest\":11},{\"src\":12,\"w\":1.5484109702862576,\"dest\":13},{\"src\":13,\"w\":1.823489852982211,\"dest\":12},{\"src\":13,\"w\":1.011071987085077,\"dest\":14},{\"src\":13,\"w\":1.2074225999744648,\"dest\":30},{\"src\":14,\"w\":0.7167080826867309,\"dest\":17},{\"src\":14,\"w\":1.3207562671517605,\"dest\":13},{\"src\":14,\"w\":1.118950355920981,\"dest\":15},{\"src\":15,\"w\":1.8726071511162605,\"dest\":16},{\"src\":15,\"w\":1.635946027210021,\"dest\":14},{\"src\":16,\"w\":1.4418017651347552,\"dest\":0},{\"src\":16,\"w\":1.5677693324851103,\"dest\":15},{\"src\":17,\"w\":1.1057039393606207,\"dest\":18},{\"src\":17,\"w\":1.0657493401365328,\"dest\":14},{\"src\":18,\"w\":1.5681055954289413,\"dest\":17},{\"src\":18,\"w\":0.550880804160341,\"dest\":19},{\"src\":18,\"w\":1.0584450243907368,\"dest\":20},{\"src\":19,\"w\":0.6852429593105193,\"dest\":18},{\"src\":19,\"w\":1.2004731394998582,\"dest\":20},{\"src\":20,\"w\":1.4193627816078853,\"dest\":18},{\"src\":20,\"w\":0.878753604473191,\"dest\":19},{\"src\":20,\"w\":1.4195513987476474,\"dest\":11},{\"src\":20,\"w\":1.0252508738027712,\"dest\":30},{\"src\":21,\"w\":0.9532629885558567,\"dest\":0},{\"src\":21,\"w\":0.9339136351151504,\"dest\":22},{\"src\":22,\"w\":0.77503542792348,\"dest\":21},{\"src\":22,\"w\":1.0711518190132492,\"dest\":23},{\"src\":23,\"w\":1.016805672689567,\"dest\":22},{\"src\":23,\"w\":1.2304170123117533,\"dest\":24},{\"src\":23,\"w\":1.4962903880836746,\"dest\":9},{\"src\":24,\"w\":0.8356693500627063,\"dest\":23},{\"src\":24,\"w\":1.3090485093357531,\"dest\":25},{\"src\":25,\"w\":0.7216646454371419,\"dest\":8},{\"src\":25,\"w\":1.0426737796145,\"dest\":24},{\"src\":25,\"w\":0.7084860462408276,\"dest\":26},{\"src\":26,\"w\":1.0266053576264493,\"dest\":1},{\"src\":26,\"w\":1.0227987431412882,\"dest\":8},{\"src\":26,\"w\":0.5713405300617479,\"dest\":25},{\"src\":27,\"w\":0.8675447814837128,\"dest\":7},{\"src\":28,\"w\":1.249725662250064,\"dest\":4},{\"src\":28,\"w\":1.1032214727491811,\"dest\":5},{\"src\":28,\"w\":1.2961326237960644,\"dest\":29},{\"src\":29,\"w\":0.92393101248433,\"dest\":28},{\"src\":30,\"w\":1.1539640587451867,\"dest\":20},{\"src\":30,\"w\":1.001001008098316,\"dest\":13}],\"Nodes\":[{\"pos\":\"35.19589389346247,32.10152879327731,0.0\",\"id\":0},{\"pos\":\"35.20319591121872,32.10318254621849,0.0\",\"id\":1},{\"pos\":\"35.20752617756255,32.1025646605042,0.0\",\"id\":2},{\"pos\":\"35.21007339305892,32.10107446554622,0.0\",\"id\":3},{\"pos\":\"35.21310882485876,32.104636394957986,0.0\",\"id\":4},{\"pos\":\"35.212111165456015,32.106235628571426,0.0\",\"id\":5},{\"pos\":\"35.20797194027441,32.104854472268904,0.0\",\"id\":6},{\"pos\":\"35.205764353510894,32.106326494117646,0.0\",\"id\":7},{\"pos\":\"35.20154022114608,32.10594485882353,0.0\",\"id\":8},{\"pos\":\"35.19805902663438,32.10525428067227,0.0\",\"id\":9},{\"pos\":\"35.197400995964486,32.10510889579832,0.0\",\"id\":10},{\"pos\":\"35.19351649233253,32.1061811092437,0.0\",\"id\":11},{\"pos\":\"35.18950462792575,32.10788938151261,0.0\",\"id\":12},{\"pos\":\"35.189568308313156,32.106617263865544,0.0\",\"id\":13},{\"pos\":\"35.18869800968523,32.104927164705884,0.0\",\"id\":14},{\"pos\":\"35.187594216303474,32.10378225882353,0.0\",\"id\":15},{\"pos\":\"35.19381366747377,32.102419275630254,0.0\",\"id\":16},{\"pos\":\"35.18992916384181,32.1043092789916,0.0\",\"id\":17},{\"pos\":\"35.19181834866828,32.10412754789916,0.0\",\"id\":18},{\"pos\":\"35.192497606133976,32.10434562521009,0.0\",\"id\":19},{\"pos\":\"35.19188202905569,32.10579947394958,0.0\",\"id\":20},{\"pos\":\"35.19691277966102,32.10240110252101,0.0\",\"id\":21},{\"pos\":\"35.197952892655366,32.10271004537815,0.0\",\"id\":22},{\"pos\":\"35.198929325262306,32.10376408571429,0.0\",\"id\":23},{\"pos\":\"35.200160479418884,32.1041457210084,0.0\",\"id\":24},{\"pos\":\"35.201731262308314,32.104636394957986,0.0\",\"id\":25},{\"pos\":\"35.20260156093624,32.10476360672269,0.0\",\"id\":26},{\"pos\":\"35.20504264245359,32.104854472268904,0.0\",\"id\":27},{\"pos\":\"35.21143190799032,32.104854472268904,0.0\",\"id\":28},{\"pos\":\"35.210264434221145,32.103909470588235,0.0\",\"id\":29},{\"pos\":\"35.19071455528652,32.106235628571426,0.0\",\"id\":30}]}\n");
//
//    public TestGraph() throws Exception {
//        Graph gr = new Graph("{\"Edges\":[{\"src\":0,\"w\":1.3118716362419698,\"dest\":16},{\"src\":0,\"w\":1.232037506070033,\"dest\":1},{\"src\":0,\"w\":0.915443564766393,\"dest\":21},{\"src\":1,\"w\":1.8635670623870366,\"dest\":0},{\"src\":1,\"w\":1.8015954015822042,\"dest\":2},{\"src\":1,\"w\":1.2579255647223926,\"dest\":26},{\"src\":2,\"w\":1.5784991011275615,\"dest\":1},{\"src\":2,\"w\":1.0631605142699874,\"dest\":3},{\"src\":2,\"w\":1.7938753352369698,\"dest\":6},{\"src\":3,\"w\":1.440561778177153,\"dest\":2},{\"src\":3,\"w\":1.2539385028794277,\"dest\":4},{\"src\":4,\"w\":1.8418222744214585,\"dest\":3},{\"src\":4,\"w\":1.1422264879958028,\"dest\":5},{\"src\":4,\"w\":1.1730460536148573,\"dest\":28},{\"src\":5,\"w\":1.5855912911662344,\"dest\":4},{\"src\":5,\"w\":1.734311926030133,\"dest\":6},{\"src\":5,\"w\":1.1029613695942861,\"dest\":28},{\"src\":6,\"w\":1.8474047229605628,\"dest\":2},{\"src\":6,\"w\":1.4964304236123005,\"dest\":5},{\"src\":6,\"w\":1.237565124536135,\"dest\":7},{\"src\":7,\"w\":1.5786081900467002,\"dest\":6},{\"src\":7,\"w\":1.3717352984705653,\"dest\":8},{\"src\":7,\"w\":1.0687354408357501,\"dest\":27},{\"src\":8,\"w\":1.2817370911337442,\"dest\":7},{\"src\":8,\"w\":1.5328553219807337,\"dest\":9},{\"src\":8,\"w\":1.025149439083266,\"dest\":25},{\"src\":8,\"w\":1.2039873817393092,\"dest\":26},{\"src\":9,\"w\":1.0350683385093797,\"dest\":23},{\"src\":9,\"w\":1.9855087252581762,\"dest\":8},{\"src\":9,\"w\":1.2861739185896588,\"dest\":10},{\"src\":10,\"w\":1.5815006562559664,\"dest\":9},{\"src\":10,\"w\":1.4962204797190428,\"dest\":11},{\"src\":11,\"w\":1.2330298625884384,\"dest\":20},{\"src\":11,\"w\":1.3784147388591739,\"dest\":10},{\"src\":11,\"w\":1.9316059913913906,\"dest\":12},{\"src\":12,\"w\":1.0666986438224981,\"dest\":11},{\"src\":12,\"w\":1.5484109702862576,\"dest\":13},{\"src\":13,\"w\":1.823489852982211,\"dest\":12},{\"src\":13,\"w\":1.011071987085077,\"dest\":14},{\"src\":13,\"w\":1.2074225999744648,\"dest\":30},{\"src\":14,\"w\":0.7167080826867309,\"dest\":17},{\"src\":14,\"w\":1.3207562671517605,\"dest\":13},{\"src\":14,\"w\":1.118950355920981,\"dest\":15},{\"src\":15,\"w\":1.8726071511162605,\"dest\":16},{\"src\":15,\"w\":1.635946027210021,\"dest\":14},{\"src\":16,\"w\":1.4418017651347552,\"dest\":0},{\"src\":16,\"w\":1.5677693324851103,\"dest\":15},{\"src\":17,\"w\":1.1057039393606207,\"dest\":18},{\"src\":17,\"w\":1.0657493401365328,\"dest\":14},{\"src\":18,\"w\":1.5681055954289413,\"dest\":17},{\"src\":18,\"w\":0.550880804160341,\"dest\":19},{\"src\":18,\"w\":1.0584450243907368,\"dest\":20},{\"src\":19,\"w\":0.6852429593105193,\"dest\":18},{\"src\":19,\"w\":1.2004731394998582,\"dest\":20},{\"src\":20,\"w\":1.4193627816078853,\"dest\":18},{\"src\":20,\"w\":0.878753604473191,\"dest\":19},{\"src\":20,\"w\":1.4195513987476474,\"dest\":11},{\"src\":20,\"w\":1.0252508738027712,\"dest\":30},{\"src\":21,\"w\":0.9532629885558567,\"dest\":0},{\"src\":21,\"w\":0.9339136351151504,\"dest\":22},{\"src\":22,\"w\":0.77503542792348,\"dest\":21},{\"src\":22,\"w\":1.0711518190132492,\"dest\":23},{\"src\":23,\"w\":1.016805672689567,\"dest\":22},{\"src\":23,\"w\":1.2304170123117533,\"dest\":24},{\"src\":23,\"w\":1.4962903880836746,\"dest\":9},{\"src\":24,\"w\":0.8356693500627063,\"dest\":23},{\"src\":24,\"w\":1.3090485093357531,\"dest\":25},{\"src\":25,\"w\":0.7216646454371419,\"dest\":8},{\"src\":25,\"w\":1.0426737796145,\"dest\":24},{\"src\":25,\"w\":0.7084860462408276,\"dest\":26},{\"src\":26,\"w\":1.0266053576264493,\"dest\":1},{\"src\":26,\"w\":1.0227987431412882,\"dest\":8},{\"src\":26,\"w\":0.5713405300617479,\"dest\":25},{\"src\":27,\"w\":0.8675447814837128,\"dest\":7},{\"src\":28,\"w\":1.249725662250064,\"dest\":4},{\"src\":28,\"w\":1.1032214727491811,\"dest\":5},{\"src\":28,\"w\":1.2961326237960644,\"dest\":29},{\"src\":29,\"w\":0.92393101248433,\"dest\":28},{\"src\":30,\"w\":1.1539640587451867,\"dest\":20},{\"src\":30,\"w\":1.001001008098316,\"dest\":13}],\"Nodes\":[{\"pos\":\"35.19589389346247,32.10152879327731,0.0\",\"id\":0},{\"pos\":\"35.20319591121872,32.10318254621849,0.0\",\"id\":1},{\"pos\":\"35.20752617756255,32.1025646605042,0.0\",\"id\":2},{\"pos\":\"35.21007339305892,32.10107446554622,0.0\",\"id\":3},{\"pos\":\"35.21310882485876,32.104636394957986,0.0\",\"id\":4},{\"pos\":\"35.212111165456015,32.106235628571426,0.0\",\"id\":5},{\"pos\":\"35.20797194027441,32.104854472268904,0.0\",\"id\":6},{\"pos\":\"35.205764353510894,32.106326494117646,0.0\",\"id\":7},{\"pos\":\"35.20154022114608,32.10594485882353,0.0\",\"id\":8},{\"pos\":\"35.19805902663438,32.10525428067227,0.0\",\"id\":9},{\"pos\":\"35.197400995964486,32.10510889579832,0.0\",\"id\":10},{\"pos\":\"35.19351649233253,32.1061811092437,0.0\",\"id\":11},{\"pos\":\"35.18950462792575,32.10788938151261,0.0\",\"id\":12},{\"pos\":\"35.189568308313156,32.106617263865544,0.0\",\"id\":13},{\"pos\":\"35.18869800968523,32.104927164705884,0.0\",\"id\":14},{\"pos\":\"35.187594216303474,32.10378225882353,0.0\",\"id\":15},{\"pos\":\"35.19381366747377,32.102419275630254,0.0\",\"id\":16},{\"pos\":\"35.18992916384181,32.1043092789916,0.0\",\"id\":17},{\"pos\":\"35.19181834866828,32.10412754789916,0.0\",\"id\":18},{\"pos\":\"35.192497606133976,32.10434562521009,0.0\",\"id\":19},{\"pos\":\"35.19188202905569,32.10579947394958,0.0\",\"id\":20},{\"pos\":\"35.19691277966102,32.10240110252101,0.0\",\"id\":21},{\"pos\":\"35.197952892655366,32.10271004537815,0.0\",\"id\":22},{\"pos\":\"35.198929325262306,32.10376408571429,0.0\",\"id\":23},{\"pos\":\"35.200160479418884,32.1041457210084,0.0\",\"id\":24},{\"pos\":\"35.201731262308314,32.104636394957986,0.0\",\"id\":25},{\"pos\":\"35.20260156093624,32.10476360672269,0.0\",\"id\":26},{\"pos\":\"35.20504264245359,32.104854472268904,0.0\",\"id\":27},{\"pos\":\"35.21143190799032,32.104854472268904,0.0\",\"id\":28},{\"pos\":\"35.210264434221145,32.103909470588235,0.0\",\"id\":29},{\"pos\":\"35.19071455528652,32.106235628571426,0.0\",\"id\":30}]}\n");
//    }
//
//
//    //DWG gr = new DWG(1000000);
//
//    @Test
//    void getNode() {
//    geoLocation p = new geoLocation(35.20504264245359,32.104854472268904,0.0);
//    geoLocation p1 = new geoLocation(35.197400995964486,32.10510889579832,0.0);
//    Node n = new Node(27,p);
//    Node n1= new Node(10,p1);
//    assertEquals(n.getKey(),gr.getNode(27).getKey());
//    assertEquals(n.getLocation().x(),gr.getNode(27).getLocation().x());
//    assertEquals(n1.getLocation().z(),0.0);
//    assertEquals(n1.getLocation().y(), 32.10510889579832);
//    assertEquals(n1.getKey(),10);
//    gr.removeNode(5);
//    assertEquals(null,gr.getNode(5));
//    }
//
//    @Test
//    void getEdge() {
//        assertEquals(10,gr.getEdge(10,11).getSrc());
//        assertEquals(1.4962204797190428,gr.getEdge(10,11).getWeight());
//        assertEquals(null,gr.getEdge(16,14));
//        assertEquals(11,gr.getEdge(10,11).getDest());
//        gr.removeEdge(10,11);
//        assertEquals(null, gr.getEdge(10,11));
//        gr.connect(10,15,12.5);
//        assertEquals(12.5,gr.getEdge(10,15).getWeight());
//        }
//        @Test
//        void addNode() {
//        geoLocation p = new geoLocation(35.18992916384181,32.1043092789916,0.0);
//        Node n = new Node(17,p);
//        gr.addNode(n);
//        assertEquals(n.getLocation().x(),gr.getNode(17).getLocation().x());
//        geoLocation p1 = new geoLocation(35.19181834866828,32.10412754789916,0.0);
//        Node n1 = new Node(18,p1);
//        assertEquals(n1.getLocation().x(),gr.getNode(18).getLocation().x());
//        gr.addNode(n1);
//        assertEquals(18,gr.getNode(18).getKey());
//        assertEquals(35.19181834866828,gr.getNode(18).getLocation().x());
//    }
//
//    @Test
//    void connect() {
//        gr.connect(16,14,8);
//        assertEquals(16,gr.getEdge(16,14).getSrc());
//        assertEquals(8, gr.getEdge(16,14).getWeight());
//        gr.connect(3,8,9);
//        assertEquals(8,gr.getEdge(3,8).getDest());
//        assertEquals(9, gr.getEdge(3,8).getWeight());
//        gr.connect(3,8,20);
//        assertEquals(9, gr.getEdge(3,8).getWeight());
//    }
//
//    @Test
//    void nodeIter() {
//        Iterator<Node> it1= gr.nodeIter();
//        Node n1= it1.next();
//        assertEquals(0, n1.getKey());
//        assertEquals(35.19589389346247,n1.getLocation().x());
//        Node n2= it1.next();
//        assertEquals(1,n2.getKey());
//        assertEquals(35.20319591121872,n2.getLocation().x());
//        int count = 2;
//        while (it1.hasNext()){
//            it1.next().getKey();
//            count++;
//        }
//        assertEquals(count,gr.nodeSize());
//        gr.removeNode(2);
//
//        try
//        {
//            it1.next();
//        }
//        catch( final RuntimeException e )
//            {
//                final String msg = "graph was changed since the iterator was constructed";
//                assertEquals(msg, e.getMessage());
//            }
//            try
//            {
//                it1.hasNext();
//            }
//            catch( final RuntimeException e )
//            {
//                final String msg = "graph was changed since the iterator was constructed";
//                assertEquals(msg, e.getMessage());
//            }
//        }
//
//        @Test
//        void edgeIter() {
//            Iterator<Edge> it1= gr.edgeIter();
//            int count = 0;
//            assertEquals(0, it1.next().getSrc());
//            while (it1.hasNext()){
//                it1.next().getSrc();
//                count++;
//            }
//            assertEquals(count+1,gr.edgeSize());
//            gr.removeEdge(0,16);
//            try
//            {
//                it1.next();
//            }
//            catch( final RuntimeException e )
//            {
//                final String msg = "graph was changed since the iterator was constructed";
//                assertEquals(msg, e.getMessage());
//            }
//            try
//            {
//                it1.hasNext();
//            }
//            catch( final RuntimeException e )
//            {
//                final String msg = "graph was changed since the iterator was constructed";
//                assertEquals(msg, e.getMessage());
//            }
//
//        }
//
//        @Test
//        void testEdgeIter() {
//            Iterator<Edge> it1= gr.edgeIter(0);
//            Edge n1= it1.next();
//            assertEquals(0, n1.getSrc());
//            assertEquals(16,n1.getDest());
//
//
//        }
//
//        @Test
//        void removeNode() {
//            assertEquals(5, gr.removeNode(5).getKey());
//            assertEquals(35.20797194027441,gr.removeNode(6).getLocation().x());
//            assertEquals(null,gr.getNode(5));
//        }
//
//        @Test
//        void removeEdge() {
//            assertEquals(5,gr.removeEdge(4,5).getDest());
//            assertEquals(6,gr.removeEdge(5,6).getDest());
//            assertEquals(null ,gr.removeEdge(4,5));
//
//        }
//
//        @Test
//        void nodeSize() {
//            assertEquals(31,gr.nodeSize());
//            gr.removeNode(16);
//            assertEquals(30,gr.nodeSize());
//        }
//
//        @Test
//        void edgeSize() {
//            assertEquals(80,gr.edgeSize());
//            gr.removeEdge(0,16);
//            assertEquals(79,gr.edgeSize());
//        }
//
//
//}
