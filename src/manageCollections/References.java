package manageCollections;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;

class VeryBig {
	private static final int SIZE = 10000;
	private long[] la = new long[SIZE];
	private String ident;
	public VeryBig(String id){
		ident = id;
	}
	public String toString(){
		return ident;
	}
	protected void finalize(){
		System.out.println("Finaling"+ident);
	}
}
	public class References{
		private static ReferenceQueue<VeryBig>  rq = new ReferenceQueue<VeryBig>();
		public static void checkQueue(){
			Reference<? extends VeryBig> inq = rq.poll();//delete first element
			if(inq!=null){
				System.out.println("in queue:"+inq.get());
			}
		}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			int size = 10;
			if(args.length>0)
				size = new Integer(args[0]);
			System.out.println("size:"+size);
			LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
			for(int i=0;i<size;i++){
				sa.add(new SoftReference<VeryBig>(new VeryBig("Soft"+i),rq));
				System.out.println("Just created:"+sa.getLast());
				checkQueue();
			}
	}

}
