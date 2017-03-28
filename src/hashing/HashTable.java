package hashing;

public abstract class HashTable {

	private Integer[] table;
	private int tableSize;
	private final int SIZE = 12;
	
	public HashTable(){
		table = new Integer[SIZE];
		tableSize = 0;
	}
	
	public boolean addInteger(int num) {
		while(tableSize<12){
			int index = num%SIZE;
			if(table[index]==null){
				table[index] = num;
				return true;
			}else{
				return collision(num);
			}
		}
		return false;
	}
	
	public abstract boolean collision(int num);
}
