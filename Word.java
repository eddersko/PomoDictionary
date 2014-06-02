package com.example.pomodictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import android.util.Log;

public class Word {
	
	public static int  getCount() {
		Log.i("count", "" + mThumbIds.length);
		return mThumbIds.length;
	}
	/*
	private static Integer[] mThumbIds = {
        R.drawable.bitaa_bear, R.drawable.dishiy_black_oak_acorn,
        R.drawable.gayna_chicken, R.drawable.hayu_dog,
        R.drawable.kabay_onions, R.drawable.kidi_cat,
        R.drawable.maayish_jinii_cornbread, R.drawable.misaxala_snake,
        R.drawable.phitam_flower, R.drawable.them_abalone,
        R.drawable.xa_water, R.drawable.xal_mussels
};
*/
	public static Integer getImage(int position){
		   return mThumbIds[position];
		}
	
private static Integer[] mThumbIds = {
	R.drawable.them_kata_abalone_shell, 
R.drawable.tsuu_arrow, R.drawable.sika_baby_basket, 
R.drawable.phika_basket, R.drawable.kal_bead, 
R.drawable.ditsiya_bone_awl, R.drawable.ih_feather, 
R.drawable.xaja_kujiya_flint_knife, R.drawable.kaday_gambling_sticks, 
R.drawable.libuu_whistle, R.drawable.shoodaxay_coyote_valley, 
R.drawable.show_east, R.drawable.chuhula_north, 
R.drawable.baloxay_potter_valley, R.drawable.yoow_south, 
R.drawable.yoow_south, R.drawable.yowxayamaa_ukiah, 
R.drawable.bow_west, R.drawable.aa_miphane_my_daughter, 
R.drawable.aa_mie_my_father, R.drawable.aamibahan_my_husband, 
R.drawable.aa_mithe_my_mother, R.drawable.aamiki_my_older_brother, 
R.drawable.khe_kawiyabah_my_son, R.drawable.aamidahan_my_wife, 
R.drawable.aamitiy_my_younger_sister, R.drawable.busa_yem_old_man, 
R.drawable.datha_yem_old_woman, R.drawable.maata_woman, 
R.drawable.dashoya_young_woman, R.drawable.xalal_willow, 
R.drawable.dishiy_xale_black_oak_tree, R.drawable.tsiwish_black_root, 
R.drawable.xabaa_cloud, R.drawable.so_clover, 
R.drawable.xawaa_xale_fir_tree, R.drawable.ho_fire, 
R.drawable.phitam_flower, R.drawable.phut_fog, 
R.drawable.jom_xale_grey_pine_tree, R.drawable.dano_hill_mountain, 
R.drawable.xashapomitin_lake, R.drawable.millee_redbud, 
R.drawable.kasil_xale_redwood_tree, R.drawable.xabeda_river, 
R.drawable.xabe_rock, R.drawable.mithaa_sun, 
R.drawable.philus_tornado, R.drawable.tibee_tule, 
R.drawable.xa_water, R.drawable.kuhum_white_sedge_root, 
R.drawable.xati_bed, R.drawable.mishin_car, 
R.drawable.uy_di_ema_eyeglasses, R.drawable.ja_house, 
R.drawable.shatson_quilt, R.drawable.tik_string, 
R.drawable.them_abalone, R.drawable.iihol_beans, 
R.drawable.dishiy_black_oak_acorn, R.drawable.gayna_roast_chicken, 
R.drawable.maayish_corn, R.drawable.maayish_jinii_cornbread, 
R.drawable.xal_mussels, R.drawable.kabay_onions, 
R.drawable.yuhuu_pinole, R.drawable.thonuk_seaweed, 
R.drawable.toltiya_tortilla, R.drawable.masan_jinii_white_bread, 
R.drawable.bitaa_bear, R.drawable.kidi_cat, 
R.drawable.kidi_cat, R.drawable.gayna_chicken, 
R.drawable.diwi_coyote, R.drawable.bishe_deer, 
R.drawable.hayu_dog, R.drawable.sha_fish, 
R.drawable.mithuulu_lizard, R.drawable.jishil_meadowlark, 
R.drawable.hakaaka_valley_quail, R.drawable.shakoodo_rabbit, 
R.drawable.tsiya_red_tailed_hawk, R.drawable.yowsha_salmon, 
R.drawable.misaxala_snake, R.drawable.bitumtu_ant};
	
/*
private static Integer[] sounds = {
    R.raw.bitaa_bear, R.raw.dishiy_black_oak_acorn,
    R.raw.gayna_chicken, R.raw.hayu_dog,
    R.raw.kabay_onions, R.raw.kidi_cat,
    R.raw.maayish_jinii_cornbread, R.raw.misaxala_snake,
    R.raw.phitam_flower, R.raw.them_abalone,
    R.raw.xa_water, R.raw.xal_mussels
};	
*/
public static Integer getSound(int position) {
	return sounds[position];
}

private static String[] categories = {"traditional", 
"traditional", "traditional", "traditional", 
"traditional", "traditional", "traditional", 
"traditional", "traditional", "traditional", 
"places", "places", "places", 
"places", "places", "places", 
"places", "places", "people", 
"people", "people", "people", 
"people", "people", "people", 
"people", "people", "people", 
"people", "people", "nature", 
"nature", "nature", "nature", 
"nature", "nature", "nature", 
"nature", "nature", "nature", 
"nature", "nature", "nature", 
"nature", "nature", "nature", 
"nature", "nature", "nature", 
"nature", "nature", "in the home", 
"in the home", "in the home", "in the home", 
"in the home", "in the home", "food", 
"food", "food", "food", 
"food", "food", "food", 
"food", "food", "food", 
"food", "food", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals"};

public static int getCategoryCount() {
	Set<String> set = new HashSet<String>(Arrays.asList(categories));
	return set.size();
}

public static String[] getCategories() {
	Set<String> set = new HashSet<String>(Arrays.asList(categories));
	String[] categories = new String[set.size()];
	int n = 0;
	for (String s: set) {
		categories[n] = s;
		n++;
	}
	return categories;
}

public static int[] getCategoryInterval(String str) {
	int[] interval = new int[2];
	boolean start = false;
	for (int i = 0; i < categories.length; i++) {
		if (!start && str.equals(categories[i])) {
			interval[0] = i;
			start = true;
		} else if (start && !(str.equals(categories[i]))) {
			interval[1] = i - 1;
			return interval;
		}		
	}
	interval[1] = categories.length;
	return interval;
}


private static Integer[] sounds = {R.raw.them_kata_abalone_shell, 
R.raw.tsuu_arrow, R.raw.sika_baby_basket, 
R.raw.phika_basket, R.raw.kal_bead, 
R.raw.ditsiya_bone_awl, R.raw.ih_feather, 
R.raw.xaja_kujiya_flint_knife, R.raw.kaday_gambling_sticks, 
R.raw.libuu_whistle, R.raw.showdaxay_coyote_valley, 
R.raw.show_east, R.raw.chuhula_north, 
R.raw.baloxay_potter_valley, R.raw.hayphoma_sherwood_laytonville, 
R.raw.yoow_south, R.raw.yoxayamaa_ukiah, 
R.raw.bow_west, R.raw.aa_miphane_my_daughter, 
R.raw.aa_mie_my_father, R.raw.aamibahan_my_husband, 
R.raw.aa_mithe_my_mother, R.raw.aamiki_my_older_brother, 
R.raw.khe_kawiyabah_my_son, R.raw.aamidahan_my_wife, 
R.raw.aamitiy_my_younger_sister, R.raw.busa_yem_old_man, 
R.raw.datha_yem_old_woman, R.raw.maata_woman, 
R.raw.dashoya_young_woman, R.raw.xalal_willow, 
R.raw.dishiy_xale_black_oak_tree, R.raw.tsiwish_black_root, 
R.raw.xabaa_cloud, R.raw.so_clover, 
R.raw.xawaa_xale_fir_tree, R.raw.ho_fire, 
R.raw.phitam_flower, R.raw.phut_fog, 
R.raw.jom_xale_grey_pine_tree, R.raw.dano_hill_mountain, 
R.raw.xashapomitin_lake, R.raw.millee_redbud, 
R.raw.kasil_xale_redwood_tree, R.raw.xabeda_river, 
R.raw.xabe_rock, R.raw.mithaa_sun, 
R.raw.philus_tornado, R.raw.tibee_tule, 
R.raw.xa_water, R.raw.kuhum_white_sedge_root, 
R.raw.xati_bed, R.raw.mishin_car, 
R.raw.uy_di_ema_eyeglasses, R.raw.ja_house, 
R.raw.shatson_quilt, R.raw.tik_string, 
R.raw.them_abalone, R.raw.iihol_beans, 
R.raw.dishiy_black_oak_acorn, R.raw.gayna_roast_chicken, 
R.raw.maayish_corn, R.raw.maayish_jinii_cornbread, 
R.raw.xal_mussels, R.raw.kabay_onions, 
R.raw.yuhuu_pinole, R.raw.thonuk_seaweed, 
R.raw.toltiya_tortilla, R.raw.masan_jinii_white_bread, 
R.raw.bitaa_bear, R.raw.kidi_cat, 
R.raw.xadalom_cat, R.raw.gayna_chicken, 
R.raw.diwi_coyote, R.raw.bishe_deer, 
R.raw.hayu_dog, R.raw.sha_fish, 
R.raw.mithuulu_lizard, R.raw.jishil_meadowlark, 
R.raw.shakaaka_valley_quail, R.raw.shakoodo_rabbit, 
R.raw.tsiya_red_tailed_hawk, R.raw.yowsha_salmon, 
R.raw.misaxala_snake, R.raw.bitumtu_ant};
 

/*private static String[] english = {
    "bear", "black oak acorn",
    "chicken", "dog",
    "onions", "cat",
    "cornbread", "snake",
    "flower", "abalone",
    "water", "mussels"
};	*/

public static String getEnglish(int position) {
	return english[position];
}

 private static String[] english = {
"abalone shell", "arrow head", "baby basket", "basket", 
"bead", "bone awl", "feather", 
"flint knife", "gambling sticks, staves", "whistle", 
"Coyote Valley", "east", "north", 
"Potter Valley", "Sherwood/Laytonville", "South", 
"Ukiah", "west", "my daughter", 
"my father", "my husband", "my mother", 
"my older brother", "my son", "my wife", 
"my younger sister", "old man", "old woman", 
"woman", "young woman", "basket willow", 
"black oak tree", "black root", "cloud, clouds", 
"clover", "fir tree", "fire", 
"flower; flowers", "fog", "grey pine tree", 
"hill, mountain", "lake", "redbud", 
"redwood tree", "river, rivers", "rock, rocks", 
"sun", "tornado; whirlwind", "tule  (tule rushes and bulbs)", 
"water", "white sedge root", "bed", 
"car, machine", "eye-glasses", "house", 
"quilt, quilts", "string", "abalone", 
"beans", "black oak acorn", "chicken", 
"corn", "cornbread", "mussels", 
"onions", "pinole", "seaweed", 
"tortilla", "white bread", "bear", 
"cat", "cat", "chicken", 
"Coyote", "deer", "dog, dogs", 
"fish", "lizard", "meadowlark", 
"quail, valley quail", "rabbit", "red-tailed hawk", 
"salmon", "snake", "ant"};
 

/*
private static String[] pomo = {
    "bitaa", "dishiy",
    "kayinaʔ", "hayu",
    "k'abay", "kidi",
    "maayish jinii","misaxala",
    "pʰit̪’am", "tʰem",
    "xa", "xal"
};*/	

public static String getPomo(int position) {
	return pomo[position];
}

private static String[] pomo = {
"tʰem kata", "ts’uu", "tsiʔka", "pʰik'a", 
"kal", "ditsiya", "ʔih", 
"xaja kujiyaʔ", "kaʔday", "libuu", 
"shoodaxay", "shoow", "juhula", 
"baloʔxay", "xayphoʔmaʔ", "yoow", 
"yowxayaʔmaa", "boow", "ʔaami-pʰane", 
"ʔaami-ʔe", "ʔaami-bahan", "ʔaami-tʰe", 
"ʔaami-ki", "khe kawiyabaa", "ʔaami-dahan", 
"ʔaami-t'iy", "busaʔ yem", "datʰaʔ yem", 
"maat̪a", "dashoyaʔ", "xalal", 
"dishiy xale", "ts'iwish", "xabaa", 
"so", "xawaa xale", "ho", 
"pʰit̪’am", "pʰut̪", "jom xale", 
"dano", "xashapomitin", "millee", 
"k'asil xale", "xabeda", "xabe", 
"mit̪'aa", "pʰilus", "tʰibee", 
"xa", "k'uhum", "xati", 
"mishin", "ʔuy-dit̪emaʔ", "ja", 
"shats'on", "t'ik'", "tʰem", 
"ʔiiholʔ", "dishi", "kayinaʔ", 
"maayish", "maayish jinii", "xal", 
"k'abay", "yuhuu", "tʰonuk'", 
"t̪olt̪iyaʔ", "masan jinii", "bitaa", 
"kidi", "xadalom", "kayinaʔ", 
"diwi", "bishe", "hayu", 
"sha", "mit̪ʰuulu", "jishil", 
"shakaaka", "shakoodo", "ts’iya", 
"yowsha", "misaxala", "bit̪'umʔt̪u"};

private static String[] description = {
"hearstmuseum.berkeley.edu, Necklace of abalone shells, Pomo", "http://drycreekrancheria.com/pomo-arrowheads/", 
"", "Grace Hudson Museum", 
"String of clamshell beads with one large magnesite bead", "Grace Hudson Museum. These awls were used to sew baskets: the basket weaver would create a hole in the fabric of the coiled basket with the awl, and would then insert the root (sewing fiber) and wrap it around the willow rod(s) foundation.", 
"Wikimedia, T. Voekler", "http://www.primitiveways.com/", 
"Grace Hudson Museum", "This traditional beaded whistle was made by Cornelius J. Stevenson in the 1940s. If such a whistle is not taken care of properly, it will whistle by itself.", 
"http://www.stpfriends.org", "Serglo. Wikimedia Commons", 
"Serglo. Wikimedia Commons", "", 
"clip", "Serglo. Wikimedia Commons", 
"http://www.menupix.com/california/n/550170/", "Serglo. Wikimedia Commons", 
"drawing", "drawing", 
"drawing", "drawing", 
"drawing", "drawing", 
"drawing", "drawing", 
"A Pomo man drilling holes in beads. 1906.http://www.firstpeople.us/", "“Aged Pomo Woman” by Edward S. Curtis [Public domain], via Wikimedia Commons", 
"“Coast Pomo Woman” by Edward S. Curtis [Public domain], via Wikimedia Commons", "“Coast Pomo girl” by Edward S. Curtis [Public domain], via Wikimedia Commons", 
"", "wikipedia", 
"http://www.eattheweeds.com", "", 
"http://www.sonoma.edu          Showy Indian clover flower head. Photo by D. Immel-Jeffery 2004.", "", 
"Wikimedia, Einar Helland Berger", "http://www.sonoma.edu       California buttercup flower and developing seed head at Ridgecrest in Marin County. Photo 2010 by D. Immel-Jeffery.  ", 
"wikimedia.public domain", "wikipedia", 
"wikipedia", "Clear Lake (wikipedia)", 
"", "Albert Bierstadt. Public domain", 
"Russian River near Duncan Mills. Ingrid Taylar,https://www.flickr.com", "", 
"Lykaestria at the English Language Wikipedia", "wikimedia.public domain", 
"Upper Lake Pomo in Tule Swamp. Edward Curtis. Wikimedia Commons", "http://www.cleanwateraction.org", 
"http://www.actaonline.org", "", 
"wikimedia commons", "Elenor Stevenson Gonzales wearing her ’uy-diṱema’", 
"", "", 
"Lewis Ronald. Wikimedia Commons", "http://simple.wikipedia.org/wiki/Abalone#California", 
"commons.wikimedia.org", "http://deborahsmall.wordpress.com/", 
"", "", 
"", "www.californiareport.org", 
"pngimg.com", "", 
"", "", 
"sannse at en.wikipedia", "wikipedia.grizzlybear", 
"", "", 
"", "Coyote closeup. Christopher Bruno. http://commons.wikimedia.org/wiki/File:Coyote _closeup.jpg.", 
"http://www.primitiveways.com", "Mikey", 
"unknown", "Western Whiptail, Cnemidophorus tigris multiscutatus. Chris Brown. 4 October 2006. http://commons.wikimedia.org/wiki/File: Cnemidophorus_tigris_multiscutatus.jpg", 
"Western meadowlark (Sturnella neglecta). Photo by Kevin Cole 2008, from http://commons.wikimedia.org/wiki/File: Western_Meadowlark.jpg.", "", 
"Black-tailed jackrabbit eating berries. Basin State Park, Utah. 28 June 2006, James Marvin Phelps, Wikimedia Commons", "Don DeBold, Wikimedia Commons", 
"wikimedia commons", "Gopher snake (Pituophis catenifer sayi).  Wikimedia Commons: http://commons.wikimedia.org/wiki/File:Pituophis _catenifer_sayi_(2).jpg.", 
""};

public static String getDescription(int position) {
	return description[position];
}

}
