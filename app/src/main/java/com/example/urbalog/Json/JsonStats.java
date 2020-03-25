package com.example.urbalog.Json;

import android.content.Context;
import android.util.Log;

import com.example.urbalog.Class.Player;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class JsonStats {
    private static String fileNameStatistics = "statistics.json";
    private static Context context;

    public static void init(Context mContext){
        context = mContext;
        deleteJson();
        if(fichierExiste())
        {
            Log.d("debug", "le fichier existe deja");
        } else {
            Log.d("debug", "Création du fichier stats");
            createFile();
        }
    }

    public static void giveContext(Context mContext){
        context = mContext;
    }

    public static void deleteJson()
    {
        Log.d("debug", "delete stats...");
        File file = context.getFileStreamPath(fileNameStatistics);
        file.delete();
    }

    public static boolean fichierExiste()
    {
        File file = context.getFileStreamPath(fileNameStatistics);
        if(file.exists()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * create an example of games
     */
    public static void createFile()
    {
        writeText("{\n" +
                "  \"games\" : [\n" +
                "      {\n" +
                "        \"date\" : \"Sun Feb 02 11:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Laurent\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Samuel\",\n" +
                "            \"age\" : \"22\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Tom\",\n" +
                "            \"age\" : \"55\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Bertrand\",\n" +
                "            \"age\" : \"15\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"John\",\n" +
                "            \"age\" : \"31\",\n" +
                "            \"pcs\" : \"Cadres et profession intellectuelle supérieure\"\n" +
                "            }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\" : \"Wed Feb 12 10:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Hugo\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Sans emploi\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Samuel\",\n" +
                "            \"age\" : \"22\",\n" +
                "            \"pcs\" : \"Ouvrier qualifié\"\n" +
                "            }\n" +
                "            ,\n" +
                "            {\n" +
                "            \"name\" : \"Jean\",\n" +
                "            \"age\" : \"12\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            }\n" +
                "            ,\n" +
                "            {\n" +
                "            \"name\" : \"Charles\",\n" +
                "            \"age\" : \"34\",\n" +
                "            \"pcs\" : \"Cadres et profession intellectuelle supérieure\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\" : \"Fri Feb 14 20:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Laurent\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\" : \"Thu Feb 20 10:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Laurent\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\" : \"Mon Feb 24 10:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Laurent\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\" : \"Wed Feb 12 00:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Laurent\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\" : \"Wed Mar 25 10:35:27 GMT+01:00 2020\",\n" +
                "        \"players\" : [\n" +
                "            {\n" +
                "            \"name\" : \"Laurent\",\n" +
                "            \"age\" : \"23\",\n" +
                "            \"pcs\" : \"Retraité\"\n" +
                "            },\n" +
                "            {\n" +
                "            \"name\" : \"Yves\",\n" +
                "            \"age\" : \"45\",\n" +
                "            \"pcs\" : \"Etudiant\"\n" +
                "            }\n" +
                "          ]\n" +
                "      }\n" +
                "    ]\n" +
                "}");
    }

    public static HashMap<String, Integer> getPercentPcs(){
        Log.d("debug", "getPercentPcs...");
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonGames = null;
        JSONObject jsonGame = null;
        JSONArray jsonPlayers = null;
        JSONObject jsonPlayer = null;

        String pcs;
        
        int nbEtudiant =0;
        int nbSansEmploi=0;
        int nbOuvrier=0;
        int nbRetraite=0;
        int nbAgriculteur=0;
        int nbEmploye=0;
        int nbCadre=0;
        int nbMain=0;
        int nbArtisant=0;
        int nbProfession=0;
        try {
            jsonText = readText();

            jsonRoot = new JSONObject(jsonText);
            jsonGames = jsonRoot.getJSONArray("games");
            for(int i=0; i<jsonGames.length(); i++){
                jsonGame = (JSONObject) jsonGames.get(i);
                jsonPlayers = jsonGame.getJSONArray("players");
                for(int j=0; j<jsonPlayers.length(); j++){
                    jsonPlayer = (JSONObject) jsonPlayers.get(j);

                    pcs = (String) jsonPlayer.get("pcs");
                    switch (pcs)
                    {
                        case "Etudiant":
                            nbEtudiant++;
                            break;
                        case "Sans emploi":
                            nbSansEmploi++;
                            break;
                        case "Ouvrier qualifié":
                            nbOuvrier++;
                            break;
                        case "Employé et personnel de service":
                            nbEmploye++;
                            break;
                        case "Cadres et profession intellectuelle supérieure":
                            nbCadre++;
                            break;
                        case "Retraité":
                            nbRetraite++;
                            break;
                        case "Agriculteur, exploitant":
                            nbAgriculteur++;
                            break;
                        case "Main d'oeuvre et ouvrier specialisé":
                            nbMain++;
                            break;
                        case "Artisan, commerçant, chef d'entreprise, profession libérale":
                            nbArtisant++;
                            break;
                        case "Profession intérmediaire, cadre moyen":
                            nbProfession++;
                            break;
                    }
                }
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        if(nbEtudiant != 0)
        {
            res.put("Etudiant", nbEtudiant);
        }
        if(nbSansEmploi != 0)
        {
            res.put("Sans emploi", nbSansEmploi);
        }
        if(nbOuvrier != 0)
        {
            res.put("Ouvrier qualifié", nbOuvrier);
        }
        if(nbEmploye != 0)
        {
            res.put("Employé et personnel de service", nbEmploye);
        }
        if(nbCadre != 0)
        {
            res.put("Cadres et profession intellectuelle supérieure", nbCadre);
        }
        if(nbRetraite != 0)
        {
            res.put("Retraité", nbRetraite);
        }
        if(nbAgriculteur != 0)
        {
            res.put("Agriculteur, exploitant", nbAgriculteur);
        }
        if(nbMain != 0)
        {
            res.put("Main d'oeuvre et ouvrier specialisé", nbMain);
        }
        if(nbArtisant != 0)
        {
            res.put("Artisan, commerçant, chef d'entreprise, profession libérale", nbArtisant);
        }
        if(nbProfession != 0)
        {
            res.put("Profession intérmediaire, cadre moyen", nbProfession);
        }
        return res;
    }


    public static HashMap<Date, Integer> getNumberPlayerByGame(){
        Log.d("debug", "getNumberPlayerByGame2...");
        HashMap<Date, Integer> res = new HashMap<>();
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonGames = null;
        JSONObject jsonGame = null;
        Date date = null;
        String sDate = null;
        int nbPlayer;
        try {
            jsonText = readText();
            jsonRoot = new JSONObject(jsonText);
            jsonGames = jsonRoot.getJSONArray("games");
            for(int i=0; i<jsonGames.length(); i++) {
                jsonGame = (JSONObject) jsonGames.get(i);
                sDate = (String) jsonGame.get("date");
                date = new Date(sDate);
                Log.d("debug", date.toString());
                nbPlayer = jsonGame.getJSONArray("players").length();
                res.put(date, nbPlayer);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static void writeGame(ArrayList<Player> list){
        Log.d("debug", "writeGame...");
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonGames = null;
        try {
            JSONObject game = new JSONObject();
            Date myDate = new Date();
            String date = new SimpleDateFormat("MM/dd/yyyy H:m:s").format(myDate);
            game.put("date", date);
            JSONArray players = new JSONArray();
            for(Player playerList : list)
            {
                JSONObject player = new JSONObject();
                player.put("name", playerList.getName());
                player.put("age", playerList.getAge().toString());
                player.put("pcs", playerList.getJob());
                players.put(player);
            }
            game.put("players", players);
            jsonText = readText();
            jsonRoot = new JSONObject(jsonText);
            jsonGames = jsonRoot.getJSONArray("games");
            jsonGames.put(game);
            writeText(jsonRoot.toString());
            
            Log.d("debug", "nb de partie = "+ jsonGames.length());
            Log.d("debug", game.toString());
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeText(String data){
        FileOutputStream fOut = null;
        OutputStreamWriter osw = null;
        try{
            fOut = context.openFileOutput(fileNameStatistics, Context.MODE_PRIVATE);
            osw = new OutputStreamWriter(fOut);
            osw.write(data);
            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                osw.close();
                fOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readText() throws IOException {
        File file = context.getFileStreamPath(fileNameStatistics);
        if (!file.exists()){
            return "fichier inexistant";
        }
        else{
            InputStream is = context.openFileInput(fileNameStatistics);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String s = null;
            while((s = br.readLine()) != null){
                sb.append(s);
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    


    //TODO
    public static int getMoyenneAge(){
        return 1;
    }
}
