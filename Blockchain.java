package Marketplace.Blockchain;

import java.util.ArrayList;
import java.util.List;


public class Blockchain {
    private List<Block> chain;

    public Blockchain(){
        chain = new ArrayList<Block>();
        chain.add(generateGenesis());
    }

    private Block generateGenesis(){
        Block genesis = new Block("0x200", new java.util.Date(), "<transactions>");
        genesis.setPrevHash(null);
        return genesis;
    }

    public void addBlock(Block blk){
        Block newBlock = blk;
        newBlock.setPrevHash(chain.get(chain.size() - 1).getHash());
        newBlock.computeHash();
        this.chain.add(newBlock);
    }

    public void displayChain(){
        for (int i = 0; i < chain.size(); i++){
            System.out.println("Block: " + i);
            System.out.println("Version: " + chain.get(i).getVersion());
            System.out.println("Timestamp: " + chain.get(i).getTimestamp());
            System.out.println("Previous hash: " + chain.get(i).getPrevHash());
            System.out.println("Hash: " + chain.get(i).getHash());
            System.out.println();
        }
    }

    public Block getLastBlock(){
        return this.chain.get(chain.size()-1);
    }


    public void isValid(){
        for (int i = chain.size()-1; i >0; i--){
            if (!(chain.get(i).getHash().equals(chain.get(i).computeHash()))){
                System.out.println("Chain is not valid, it has been tampered with");
                return;
            }
            if (!(chain.get(i).getPrevHash().equals(chain.get(i -1).computeHash()))){
                System.out.println("Chain is not valid, it has been tampered with");
            }
        }
        System.out.println("Chain is valid");
    }


}
