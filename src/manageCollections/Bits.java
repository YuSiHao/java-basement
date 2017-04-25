package manageCollections;

import java.util.BitSet;
import java.util.Random;

public class Bits {
	public static void printBitSet(BitSet b){//BitSet是64位的
		System.out.println("bits:"+b);
		StringBuilder bbits = new StringBuilder();
		for(int j=0;j<b.size();j++){
			bbits.append(b.get(j)?"1":"0");//保存方式
		}
		System.out.println("bit pattern:"+bbits);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random(47);
		System.out.println("random:"+random.nextInt());
		byte bt = (byte) random.nextInt();
		System.out.println("bt:"+bt);
		BitSet BB = new BitSet();
		for(int i=7;i>=0;i--){
			if(((1<<i)&bt)!=0){
				System.out.println("decide:"+((1<<i)&bt));
				BB.set(i);
			}else {
				System.out.println("decide:"+((1<<i)&bt));
				BB.clear(i);
			}
			System.out.println("byte value:"+bt);
			printBitSet(BB);
		}
		
	}

}
