package scoringSystem;

public class NameSaver {

        private String[] Athlets;
        private String contest;
        public void SetContest (String ContestName){
            contest=ContestName;}


        public void setAthlets(int NumberOfAthlets) {

            if (NumberOfAthlets >40){
                NumberOfAthlets=40;

            }
            Athlets = new String[NumberOfAthlets];
        }

        public void setName(int place, String atheltesName) {

            Athlets[place] = atheltesName;
        }





        public String [] getNames() {

            return Athlets;
        }
    }
