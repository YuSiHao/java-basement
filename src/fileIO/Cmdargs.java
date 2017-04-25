package fileIO;

public class Cmdargs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0){
			System.out.println("null");
		}else{
			for(String arg:args){
				System.out.println("args:"+arg);
			}
		}
	}
}
