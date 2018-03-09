/*
 * << Crazy Copter >>
 * 
 * Created by Team 11
 * ------------------
 *   Brandon Banks
 *    Quang Tran
 *    Noah Sauls
 *    Peter Graef
 * ------------------
 * CS 321 - Rochowiak
 * ------------------
 * Overview:
 *   Basic side scroler game in JAVA
 *	 Try to avoid oncoming eneimes on screen to survive
 *   Click on options to load/save/modify player profile
 *
 * Controls (In-Game):
 *   SPACEBAR  - jump
 *   A         - move left
 *   D         - move right
 *   LeftClick - pause/resume
 *
 */
package CrazyCopter.Database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class KVDatabase 
{
    private static String databaseFile;
    
    public KVDatabase(String dbFile)
    {
        databaseFile = dbFile;
        File f = new File(databaseFile);
        if (!f.exists())
        {
            try
            {
                f.createNewFile();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
    }
    
    public KVDatabase()
    {
        this("save.txt");
    }
    
    public static String getDatabaseFile()
    {
        return databaseFile;
    }
    
    public static  void setDatabaseFile(String db)
    {
        databaseFile = db;
    }


   
    public static int loadInt(String key, String value)
    {
        int val = 0;
        String up_val = loadValue(key, value);
        try
        {
            val = Integer.parseInt(up_val);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return val;
    }
    
    public static  float loadFloat(String key, String value)
    {
        float val = 0;
        String up_val = loadValue(key, value);
        try
        {
            val = Float.parseFloat(up_val);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return val;
    }
    
    public static String loadString(String key, String value)
    {
        String val = loadValue(key, value);
        return val;
    }
    
    public static  double loadDouble(String key, String value)
    {
        double val = 0.0;
        String up_val = loadValue(key, value);
        try
        {
            val = Double.parseDouble(up_val);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return val;
    }
    
    public static  void writeValue(String key, String value, String data)
    {
        String write_string = value + " = " + data;
        ArrayList<String> file_data = new ArrayList<String>();
        boolean found_key = false, found_value = false;
        int key_line = 0, value_line = 0, cur_line = 0;
        try
        {
            BufferedReader buff = new BufferedReader(new FileReader(databaseFile));
            String line = "";
            while((line = buff.readLine()) != null)
            {
                file_data.add(line);
                if (line.contains("[") && !found_key)
                {
                    if (line.contains(key))
                    {
                        found_key = true;
                        key_line = cur_line;
                    }
                }
                if (line.contains(value) && found_key)
                {
                    found_value = true;
                    value_line = cur_line;
                }
                cur_line++;
            }
            buff.close();
            if (found_key && found_value)
            {
                file_data.set(value_line, write_string);
            }
            else if (found_key && !found_value)
            {
                file_data.add(key_line+1, write_string);
            }
            else if (!found_key && !found_value)
            {
                file_data.add("["+key+"]");
                file_data.add(write_string);
            }
         /* // Debugg use
            for (String s : file_data)
            {
                System.out.println(s);
            }
         */
            BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFile));                        
            for (String s : file_data)
            {
                writer.write(s);
                writer.newLine();
                
            }
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
    }
    
    private static String loadValue(String key, String value)
    {
        String ret = "";
        try
        {
            BufferedReader buff = new BufferedReader(new FileReader(databaseFile));
            String cur_value = "";
            boolean found_key = false;
            while ((cur_value = buff.readLine()) != null)
            {
                if (cur_value.contains("[") && !found_key)
                {
                    if (cur_value.contains(key))
                    {
                        found_key = true;
                    }
                }
                if (cur_value.contains(value) && found_key)
                {
                    cur_value = cur_value.trim();
                    cur_value = cur_value.replace(value+"=", "");
                    ret = cur_value;
                }
            }
            buff.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        return ret;
    }




    public static boolean isUnique(String key)
    {
        boolean found = false;
        try
        {
            BufferedReader buff = new BufferedReader(new FileReader(databaseFile));
            String cur_value = "";
            
            while ((cur_value = buff.readLine()) != null)
            {
                if (cur_value.contains("[") && !found)
                {
                    if (cur_value.contains(key))
                    {
                        found = true;
                    }
                }
            }
            buff.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        return found;
    }

}
