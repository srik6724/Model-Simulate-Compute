package wizPackage;

public interface HeapArena {
	
	static int HeapArenaNumber()
	{
		return (int)(Math.random() * 6) + 1; 
	}
	
	default String HeapArenaName()
	{
		return "Heap Arena"; 
	}
}
