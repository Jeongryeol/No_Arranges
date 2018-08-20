package com.semi.address;

public class AddressBookSimulation {

	public static void main(String[] args) {
		AddressBookDAO aBookDAO = new AddressBookDAO();
		AddressVO pavo = new AddressVO();
		//aBookDAO.addrInsert(pavo);
		AddressVO ravos[] = null;
		//pavo.setAno(14);
		//ravos = aBookDAO.getAddressList(pavo);
		//System.out.println("ravos.length: "+ravos.length);
		//System.out.println("이름:"+ravos[0].getA_name());
		
		//int anos[] = {14,15,17};
		//aBookDAO.addrDelete(anos);
		
		pavo.setAno(30);
		pavo.setA_id("nono");
		pavo.setA_pw("1");
		pavo.setGender("1");
		pavo.setA_bigo("테스트");
		aBookDAO.addrUpdate(pavo);
		int result = aBookDAO.addrUpdate(pavo);
		System.out.println("simulationi : result : "+result);
	}

}
