package com.chat;

import java.util.ArrayList;
import java.util.List;

import com.ch6.Sonata;
import com.ch7.Encaps_TimeVO;

public class ArrayListTest {

	ArrayList al = new ArrayList();	//< >(Generic)戚 紫遂馬走 省焼辞 井壱研 左鎧澗 鎧遂(映舌紫牌)
	ArrayList<String> als = new ArrayList<String>(); //薦革遣戚 赤聖凶 陥献展脊 眼奄澗 嬢胸惟 馬走?
	ArrayList<Encaps_TimeVO> ald = new ArrayList<Encaps_TimeVO>(); //戚係惟 馬檎 掬!
	ArrayList<Object> alo = new ArrayList<Object>(); //置雌是 神崎詮闘研 薦革遣拭 潤獄形辞 更窮 陥 凶形隔聖 呪 赤嬢推 せせ
	
	List al2 = new ArrayList();		//昔斗凪戚什 戚硯  = new 姥薄端適掘什
	
	List<String> al3 = new ArrayList<String>();	//昔斗凪戚什<適掘什> 戚硯 = new 姥薄端適掘什<適掘什>();
	List<Sonata> al4 = new ArrayList<Sonata>();

	//List<T>	al5 = new ArrayList<T>();
	//al痕呪澗 薦革遣戚 蒸生艦猿 嬢恐 展脊戚窮 眼聖 呪 赤嬢推.
	//益訓汽 襖鎧 承 凶澗 嬢胸惟 展脊聖 硝 呪 赤澗 杏猿?
	
	public void setList() {
		al.add("馬馬");
		al.add(new Sonata());
		al.add(10);//al精 薦革遣戚 蒸生艦 嬢恐 展脊戚窮 眼聖 呪 赤陥.
		//聡, 薦革遣戚 赤生檎 旭精 展脊幻 眼聖 呪 赤陥.
		//益訓汽, 薦革遣戚 赤嬢亀 辞稽 陥献 展脊聖 眼壱 粛陥.....
/*		als.add("馬馬");
		als.add(new Sonata());	//益 紫弘税 舛左澗... String幻 級嬢赤澗惟 焼観汽....
		als.add(10);			//収切亀 眼移醤 馬澗汽 ばばば...
*/		
		//神崎詮闘研 薦革遣生稽 梅希艦 更窮 陥 眼聖呪赤嬢!!!せせせ
		alo.add("馬馬");
		alo.add(new Sonata());
		alo.add(10);
		//益訓汽... 剰革 襖馨凶.. 益惟 嬢恐 展脊昔匝 硝壱 眼焼襖鎧走...?
	}

	//陥丞廃 展脊生稽 襖馨凶 莫聖 溌昔馬澗 号狛!
	public void getList() {
		for(int i=0;i<alo.size();i++) {
			if(alo.get(i) instanceof String) {//格 箸獣 String展脊戚艦?
				String str = (String)alo.get(i);//String莫穿発
				System.out.println(str);
			}else if(alo.get(i) instanceof Integer) {//格 箸獣 Integer展脊戚艦?
				Integer intg = (Integer)alo.get(i);//Integer莫穿発
				System.out.println(intg);
			}else if(alo.get(i) instanceof Sonata) {//格 箸什 Sonata適掘什 展脊戚艦?
				Sonata myCar = (Sonata)alo.get(i);
				System.out.println(myCar);
			}
		}
	}
	
	//社蟹展稽 叔柔
	public void setList2() {
		//社蟹展稽採斗 3企税 社蟹展研 幻級嬢左切
		Sonata ysCar = new Sonata();
		Sonata gsCar = new Sonata();
		Sonata bhCar = new Sonata();
		//社蟹展税 紗亀級戚?? (馬蟹税 適掘什亜 亜走澗 旭精 痕呪昔汽 陥献 葵聖 煽舌拝 呪 赤陥)
		ysCar.speed = 350; //慎縦切疑託澗 透閑生稽 託税 紗亀亜 畳短 匙牽惟 郊蚊兜紹陥
		gsCar.speed = 220; //鋭失切疑託澗 戚舛亀稽..
		bhCar.speed = 100; //左薄切疑託澗 戚舛亀稽..
		//戚 3企税 切疑託税 段奄鉢吉 痕呪葵聖 al4拭 眼焼左切
		al4.add(ysCar);
		al4.add(gsCar);
		al4.add(bhCar);
		//眼焼浬 葵聖 襖鎧澗 五社球 getList2()研 条嬢左切
		getList2();
	}
	
	public void getList2() {
		//鎧照拭 赤澗 展脊精 Sonata稽 乞砧 旭奄凶庚拭, instanceof稽 展脊聖 達聖 琶推澗 蒸陥.
		for(int i=0;i<al4.size();i++) {
			Sonata gnomCar = al4.get(i);
			System.out.println(gnomCar.speed);
		}
	}
	
	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
/*		alt.setList();
		alt.getList();
*/
		alt.setList2();
		}

}
