package com.example.pomodictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import android.util.Log;

public class Word {
	
	public static int  getCount() {
		Log.i("count", "" + mThumbIds.length);
		return mThumbIds.length;
	}

	public static Integer getImage(int position){
		   return mThumbIds[position];
		}
	
private static Integer[] mThumbIds = {
R.drawable.them_kata_abalone_shell, 
R.drawable.tsuu_arrow, R.drawable.sika_baby_basket, 
R.drawable.phika_basket, R.drawable.kal_bead, 
R.drawable.ditsiya_bone_awl, R.drawable.ih_feather, 
R.drawable.xaja_kujiya_flint_knife, R.drawable.kaday_gambling_sticks, 
R.drawable.libuu_whistle, R.drawable.showdaxay_coyote_valley, 
R.drawable.show_east, R.drawable.chuhula_north, 
R.drawable.baloxay_potter_valley, R.drawable.hayphoma_sherwood_laytonville, 
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
R.drawable.bitaa_bear,  
R.drawable.kidi_cat, R.drawable.gayna_chicken, 
R.drawable.diwi_coyote, R.drawable.bishe_deer, 
R.drawable.hayu_dog, R.drawable.sha_fish, 
R.drawable.mithuulu_lizard, R.drawable.jishil_meadowlark, 
R.drawable.hakaaka_valley_quail, R.drawable.shakoodo_rabbit, 
R.drawable.tsiya_red_tailed_hawk, R.drawable.yowsha_salmon, 
R.drawable.misaxala_snake, R.drawable.bitumtu_ant};
	
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
"animals", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals", 
"animals", "animals", "animals"};

public static String getCategory(int position) {
	return categories[position];
}

public static String[] getCategories() {
	
	Set<String> set = new HashSet<String>(Arrays.asList(categories));
	String[] categories = new String[set.size() + 1];
	int n = 0;
	
	for (String s: set) {
		categories[n] = s;
		n++;
	}
	
	categories[n] = "all";
	return categories;
}

public static int[] getCategoryInterval(String str) {
	
	int[] interval = new int[2];
	
	if (str.equals("all")) {
		interval[1] = getCount()-1;
		return interval;
	}
	
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
	
	interval[1] = categories.length - 1;
	return interval;
}

public static Map<String, Integer> getCategoryMap() {
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	map.put("people", R.drawable.people);
	map.put("nature", R.drawable.nature);
	map.put("animals", R.drawable.animals);
	map.put("places", R.drawable.places);
	map.put("food", R.drawable.food);
	map.put("in the home", R.drawable.home);
	map.put("traditional", R.drawable.traditional);
	map.put("all", R.drawable.all);
	
	return map;
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
R.raw.bitaa_bear, 
R.raw.xadalom_cat, R.raw.gayna_chicken, 
R.raw.diwi_coyote, R.raw.bishe_deer, 
R.raw.hayu_dog, R.raw.sha_fish, 
R.raw.mithuulu_lizard, R.raw.jishil_meadowlark, 
R.raw.shakaaka_valley_quail, R.raw.shakoodo_rabbit, 
R.raw.tsiya_red_tailed_hawk, R.raw.yowsha_salmon, 
R.raw.misaxala_snake, R.raw.bitumtu_ant};
 
public static String getEnglish(int position) {
	return english[position];
}
 
public static String getPomo(int position) {
	return pomo[position];
}

private static String[] pomo = {
"tʰem kata", "ts’uu", "tsiʔka", "pʰik'a", 
"kal", "ditsiya", "ʔih", 
"xaja kujiyaʔ", "kaʔday", "libuu", 
"sho:daxay", "sho:w", "juhula", 
"baloʔxay", "xayphoʔmaʔ", "yo:w", 
"yowxayaʔmaa", "bo:w", "ʔa:mi-pʰane", 
"ʔa:mi-ʔe", "ʔa:mi-bahan", "ʔa:mi-tʰe", 
"ʔa:mi-ki", "khe kawiyaba:", "ʔa:mi-dahan", 
"ʔa:mi-t'iy", "busaʔ yem", "datʰaʔ yem", 
"ma:t̪a", "dashoyaʔ", "xalal", 
"dishiy xale", "ts'iwish", "xaba:", 
"so", "xawa: xale", "ho", 
"pʰit̪’am", "pʰut̪", "jom xale", 
"dano", "xashapomitin", "millee", 
"k'asil xale", "xabeda", "xabe", 
"mit̪'aa", "pʰilus", "tʰibee", 
"xa", "k'uhum", "xati", 
"mishin", "ʔuy-dit̪emaʔ", "ja", 
"shats'on", "t'ik'", "tʰem", 
"ʔiiholʔ", "dishi", "kayinaʔ", 
"ma:yish", "ma:yish jini:", "xal", 
"k'abay", "yuhu:", "tʰonuk'", 
"t̪olt̪iyaʔ", "masan jini:", "bita:", 
 "xadalom", "kayinaʔ", 
"diwi", "bishe", "hayu", 
"sha", "mit̪ʰu:lu", "jishil", 
"shaka:ka", "shako:do", "ts’iya", 
"yowsha", "misaxala", "bit̪'umʔt̪u"};

private static String[] english = {
"abalone shell", "arrow head", "baby basket", "basket", 
"bead", "bone awl", "feather", 
"flint knife", "gambling sticks, staves", "whistle", 
"Coyote Valley", "east", "north", 
"Potter Valley", "Sherwood/Laytonville", "south", 
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
"cat", "chicken", 
"Coyote", "deer", "dog, dogs", 
"fish", "lizard", "meadowlark", 
"quail, valley quail", "rabbit", "red-tailed hawk", 
"salmon", "snake", "ant"};

private static String[] description = {
"hearstmuseum.berkeley.edu, Necklace of abalone shells, Pomo", "Mendocino County Museum", 
"Photo by M.C. O'Connor", "Grace Hudson Museum & Sun House, Ukiah, CA", 
"String of clamshell beads with	one large magnesite bead", "Grace Hudson Museum & Sun House, Ukiah, CA. These awls were used to sew baskets: the basket weaver would create a hole in the fabric of the coiled basket with the awl, and would then insert the root (sewing fiber) and wrap it around the willow rod(s) foundation.", 
"Wikimedia, T. Voekler", "Dino Labiste. http://www.primitiveways.com/", 
"Grace Hudson Museum & Sun House, Ukiah, CA", "This traditional beaded whistle was made by Cornelius J. Stevenson in the 1940s. If such a whistle is not taken care of properly, it will whistle by itself. Photo: mco@bu.edu", 
"Caltrans photo, 1953, courtesy of Eddie F. Knight, Coyote Valley Band of Pomo Indians", "Serglo. Wikimedia Commons", 
"Serglo. Wikimedia Commons", "www.MedocinoOrganics.com", 
"mco@bu.edu", "Serglo. Wikimedia Commons", 
"mco@bu.edu", "Serglo. Wikimedia Commons", 
"Drawing", "Drawing", 
"Drawing", "Drawing", 
"Drawing", "Drawing", 
"Drawing", "Drawing", 
"MAN NEEDS DESCRIPTION", "“Aged Pomo Woman” by Edward S. Curtis [Public domain], via Wikimedia Commons", 
"“Coast Pomo Woman” by Edward S. Curtis [Public domain], via Wikimedia Commons", "“Coast Pomo girl” by Edward S. Curtis [Public domain], via Wikimedia Commons", 
"Dino Labiste. http://www.primitiveways.com", "Wikipedia", 
"http://www.eattheweeds.com", "mco@bu.edu", 
"http://www.sonoma.edu Showy Indian clover flower head. Photo by D. Immel-Jeffery 2004.", "Wikimedia Commons", 
"Einar Helland Berger. Wikimedia Commons", "http://www.sonoma.edu California buttercup flower and developing seed head at Ridgecrest in Marin County. Photo 2010 by D. Immel-Jeffery.  ", 
"Wikimedia Commons", "Wikimedia Commons", 
"mco@bu.edu", "Clear Lake (wikipedia)", 
"mco@bu.edu", "Albert Bierstadt. Public domain", 
"mco@bu.edu", "photos-public-domain.com", 
"Lykaestria at the English Language Wikipedia", "Wikimedia. Public domain", 
"Upper Lake Pomo in Tule Swamp. Edward Curtis. Wikimedia Commons", "Alex Anliker. Wikimedia Commons", 
"Photo by Debbie Delatour. http://www.actaonline.org", "Tim Evanson. Wikimedia Commons", 
"Wikimedia Commons", "Elenor Stevenson Gonzales wearing her ’uy-diṱema’", 
"mco@bu.edu", "mco@bu.edu. Quilt made by Elenor Stevenson Gonzales", 
"Lewis Ronald. Wikimedia Commons", "http://simple.wikipedia.org/wiki/Abalone#California", 
"Wikimedia Commons", "mco@bu.edu", 
"Wikimedia Commons", "Wikimedia Commons", 
"Wikimedia Commons", "www.californiareport.org", 
"pngimg.com", "nomeatathlete", 
"Grace Hudson Museum & Sun House, Ukiah, CA", "mco@bu.edu", 
"pngimg.com", "wikipedia.grizzlybear", "Wikimedia Commons", 
"Wikipedia Commons", "Coyote closeup. Christopher Bruno. http://commons.wikimedia.org/wiki/File:Coyote _closeup.jpg.", 
"Dino Labiste. http://www.primitiveways.com", "Photo by J.T. O'Connor", 
"pngimg.com", "Western Whiptail, Cnemidophorus tigris multiscutatus. Chris Brown. 4 October 2006. http://commons.wikimedia.org/wiki/File: Cnemidophorus_tigris_multiscutatus.jpg", 
"Western meadowlark (Sturnella neglecta). Photo by Kevin Cole 2008, from http://commons.wikimedia.org/wiki/File: Western_Meadowlark.jpg.", "Wikimedia Commons", 
"Black-tailed jackrabbit eating berries. Basin State Park, Utah. 28 June 2006, James Marvin Phelps, Wikimedia Commons", "Don DeBold, Wikimedia Commons", 
"Wikimedia Commons", "Gopher snake (Pituophis catenifer sayi).  Wikimedia Commons: http://commons.wikimedia.org/wiki/File:Pituophis _catenifer_sayi_(2).jpg.", 
"Wikimedia Commons"};

public static String getDescription(int position) {
	return description[position];
}

}
