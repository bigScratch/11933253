package com.gdstruc.module5;

public class SimpleHashTable {
    private StoredPlayer[] hashtable;

    public SimpleHashTable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey))
        {
            // do linear probing
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey))
        {
            System.out.println("Sorry ry, element at position yeah " + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key)
    {
       int hashedKey = findKey(key);

       if (hashedKey == -1)
       {
           return null;
       }
       return hashtable[hashedKey].value;
    }

    public int findKey(String key)
    {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }

        // do linear probing
        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex
                && hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key))
        {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null
        && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }
        return -1;
    }

    public void removeKey(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            System.out.println("Specified element cannot be found, deletion inapplicable . . .");
        }
        else
        {
            hashtable[hashedKey] = null;
        }
    }

    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else
            {
                System.out.println("Element " + i + " null");
            }
        }
    }


}
