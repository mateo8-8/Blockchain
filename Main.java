package Marketplace.Blockchain;


public class Main {

    public static void main(String[] args) {
	// write your code here
       
        Blockchain mateoCoin = new Blockchain();

        /** 
        Block a = new Block("0x200", new java.util.Date(), "<transactions>");
        Block b = new Block("0x200", new java.util.Date(), "<transactions>");
        Block c = new Block("0x200", new java.util.Date(), "<transactions>");
        Block d = new Block("0x200", new java.util.Date(), "<transactions>");
        Block e = new Block("0x200", new java.util.Date(), "<transactions>");


        mateoCoin.addBlock(a);
        mateoCoin.addBlock(b);
        mateoCoin.addBlock(c);
        mateoCoin.addBlock(d);
        mateoCoin.addBlock(e);

        mateoCoin.getLastBlock().setPrevHash("ABCDE");
*/

        for(int i = 0; i < 5; i++){
            Block a = new Block("0x200", new java.util.Date(), "<transactions>");
            mateoCoin.addBlock(a);
        }
        mateoCoin.displayChain();

        mateoCoin.isValid();
        


    }
}
