package scoringSystem;

import java.security.PrivateKey;

public class NameSaver {

        private  String[] athlets;
        private String contest;
        public void SetContest (String ContestName){
            contest=ContestName;}


        public void setAthlets(int NumberOfAthlets) {

            if (NumberOfAthlets >40){
                NumberOfAthlets=40;

            }
            athlets = new String[NumberOfAthlets];
        }

        public void setName(int place, String atheltesName) {

            athlets[place] = atheltesName;
        }





        public String getNames() {

            return athlets;
        }
    }
