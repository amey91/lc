package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import leetcode.commons.Amey;
import leetcode.commons.ListNode;

public class Solution {
    private class Pair{
        String string;
        int depth;
        Pair(String string, int depth){
            this.string=string;
            this.depth=depth;
        }
        
        @Override
        public boolean equals(Object o){
            if(o.getClass()!=this.getClass())
                return false;
            Pair p = (Pair)o;
            if(p.string.equals(this.string))
                return true;
            return false;
        }
        
        @Override
        public int hashCode(){
            // int prime = 7907;
            return this.string.hashCode();
        }
    }
    
    public int ladderLength(String start, String end, Set<String> dict) {
        ArrayList<Pair> list = new ArrayList<>();
        int count = 1;
        list.add(new Pair(start, count));
        
        while(list.size()>0){
            Pair currPair=list.remove(list.size()-1);
            Iterator<String> iter = dict.iterator();
            while(iter.hasNext()){
                String dictWord = iter.next();
                if(canTransform(currPair.string, dictWord)){
                    // if end reached
                    if(dictWord.equals(end))
                        return currPair.depth+1;
                    list.add(0, new Pair(dictWord, currPair.depth+1));
                    iter.remove();
                }
            }
        }
        return 0;
    }
    
    private boolean canTransform(String begin, String end){
        if(begin.equals(end))
            return false;
        int diff=0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=end.charAt(i))
                diff++;
            if(diff>1)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	ListNode<String> sss = (ListNode<String>) Amey.convertStringToList("[\"dose\",\"ends\",\"dine\",\"jars\",\"prow\",\"soap\",\"guns\",\"hops\",\"cray\",\"hove\",\"ella\",\"hour\",\"lens\",\"jive\",\"wiry\",\"earl\",\"mara\",\"part\",\"flue\",\"putt\",\"rory\",\"bull\",\"york\",\"ruts\",\"lily\",\"vamp\",\"bask\",\"peer\",\"boat\",\"dens\",\"lyre\",\"jets\",\"wide\",\"rile\",\"boos\",\"down\",\"path\",\"onyx\",\"mows\",\"toke\",\"soto\",\"dork\",\"nape\",\"mans\",\"loin\",\"jots\",\"male\",\"sits\",\"minn\",\"sale\",\"pets\",\"hugo\",\"woke\",\"suds\",\"rugs\",\"vole\",\"warp\",\"mite\",\"pews\",\"lips\",\"pals\",\"nigh\",\"sulk\",\"vice\",\"clod\",\"iowa\",\"gibe\",\"shad\",\"carl\",\"huns\",\"coot\",\"sera\",\"mils\",\"rose\",\"orly\",\"ford\",\"void\",\"time\",\"eloy\",\"risk\",\"veep\",\"reps\",\"dolt\",\"hens\",\"tray\",\"melt\",\"rung\",\"rich\",\"saga\",\"lust\",\"yews\",\"rode\",\"many\",\"cods\",\"rape\",\"last\",\"tile\",\"nosy\",\"take\",\"nope\",\"toni\",\"bank\",\"jock\",\"jody\",\"diss\",\"nips\",\"bake\",\"lima\",\"wore\",\"kins\",\"cult\",\"hart\",\"wuss\",\"tale\",\"sing\",\"lake\",\"bogy\",\"wigs\",\"kari\",\"magi\",\"bass\",\"pent\",\"tost\",\"fops\",\"bags\",\"duns\",\"will\",\"tart\",\"drug\",\"gale\",\"mold\",\"disk\",\"spay\",\"hows\",\"naps\",\"puss\",\"gina\",\"kara\",\"zorn\",\"boll\",\"cams\",\"boas\",\"rave\",\"sets\",\"lego\",\"hays\",\"judy\",\"chap\",\"live\",\"bahs\",\"ohio\",\"nibs\",\"cuts\",\"pups\",\"data\",\"kate\",\"rump\",\"hews\",\"mary\",\"stow\",\"fang\",\"bolt\",\"rues\",\"mesh\",\"mice\",\"rise\",\"rant\",\"dune\",\"jell\",\"laws\",\"jove\",\"bode\",\"sung\",\"nils\",\"vila\",\"mode\",\"hued\",\"cell\",\"fies\",\"swat\",\"wags\",\"nate\",\"wist\",\"honk\",\"goth\",\"told\",\"oise\",\"wail\",\"tels\",\"sore\",\"hunk\",\"mate\",\"luke\",\"tore\",\"bond\",\"bast\",\"vows\",\"ripe\",\"fond\",\"benz\",\"firs\",\"zeds\",\"wary\",\"baas\",\"wins\",\"pair\",\"tags\",\"cost\",\"woes\",\"buns\",\"lend\",\"bops\",\"code\",\"eddy\",\"siva\",\"oops\",\"toed\",\"bale\",\"hutu\",\"jolt\",\"rife\",\"darn\",\"tape\",\"bold\",\"cope\",\"cake\",\"wisp\",\"vats\",\"wave\",\"hems\",\"bill\",\"cord\",\"pert\",\"type\",\"kroc\",\"ucla\",\"albs\",\"yoko\",\"silt\",\"pock\",\"drub\",\"puny\",\"fads\",\"mull\",\"pray\",\"mole\",\"talc\",\"east\",\"slay\",\"jamb\",\"mill\",\"dung\",\"jack\",\"lynx\",\"nome\",\"leos\",\"lade\",\"sana\",\"tike\",\"cali\",\"toge\",\"pled\",\"mile\",\"mass\",\"leon\",\"sloe\",\"lube\",\"kans\",\"cory\",\"burs\",\"race\",\"toss\",\"mild\",\"tops\",\"maze\",\"city\",\"sadr\",\"bays\",\"poet\",\"volt\",\"laze\",\"gold\",\"zuni\",\"shea\",\"gags\",\"fist\",\"ping\",\"pope\",\"cora\",\"yaks\",\"cosy\",\"foci\",\"plan\",\"colo\",\"hume\",\"yowl\",\"craw\",\"pied\",\"toga\",\"lobs\",\"love\",\"lode\",\"duds\",\"bled\",\"juts\",\"gabs\",\"fink\",\"rock\",\"pant\",\"wipe\",\"pele\",\"suez\",\"nina\",\"ring\",\"okra\",\"warm\",\"lyle\",\"gape\",\"bead\",\"lead\",\"jane\",\"oink\",\"ware\",\"zibo\",\"inns\",\"mope\",\"hang\",\"made\",\"fobs\",\"gamy\",\"fort\",\"peak\",\"gill\",\"dino\",\"dina\",\"tier\"]", '[', ']', ",", String.class);
    	sss.add("aslk");
    	Set<String> ss = new HashSet<>(sss);
    	System.out.println(s.ladderLength("nape","mild", ss));
    }
}