package enumTest;

public class RandomTest {
	enum Activity{SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FALLING,FLYING}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++)
			System.out.print(Enums.Random(Activity.class)+" ");
	}

}
