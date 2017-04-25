package enumTest;

public enum SpaceShip {
	SCOUNT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSGIP;
	public String toString(){
		String id = name();
		System.out.println("id:"+id);
		String lower = id.substring(1).toLowerCase();
		System.out.println("lower:"+lower);
		return id.charAt(0)+lower;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(SpaceShip s:values()){
			System.out.println(s);
		}
	}
	
}
