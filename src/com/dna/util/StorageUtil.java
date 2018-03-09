package com.dna.util;

import org.neo.smartcontract.framework.SmartContract;
import org.neo.smartcontract.framework.services.neo.Runtime;
import org.neo.smartcontract.framework.services.neo.Storage;

/**
 * Created by peng on 18/3/9.
 */
public class StorageUtil extends SmartContract {

    public static boolean insert(String id, byte[] content){
        if (!Runtime.checkWitness(content)) return false;
        byte[] value = Storage.get(Storage.currentContext(), id);
        if (value != null) return false;
        Storage.put(Storage.currentContext(), id, content);
        return true;
    }

    public static boolean delete(String id){
        byte[] owner = Storage.get(Storage.currentContext(), id);
        if (owner == null) return false;
        if (!Runtime.checkWitness(owner)) return false;
        Storage.delete(Storage.currentContext(), id);
        return true;
    }

    public static byte[] get(String id){
        return Storage.get(Storage.currentContext(),id);
    }

    public static boolean transfer(String id, byte[] content)
    {
        if (!Runtime.checkWitness(content)) return false;
        byte[] from = Storage.get(Storage.currentContext(), id);
        if (from == null) return false;
        if (!Runtime.checkWitness(from)) return false;
        Storage.put(Storage.currentContext(), id, content);
        return true;
    }
}
