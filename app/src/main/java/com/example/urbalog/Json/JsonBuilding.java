package com.example.urbalog.Json;

import android.content.Context;
import android.util.Log;

import com.example.urbalog.Class.Building;

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
import java.util.ArrayList;

public class JsonBuilding {

    private static String fileNameBuilding = "buildings.json";
    private static Context context;

    /**
     * Check if json file exist
     *
     * @return boolean
     */
    public static boolean fichierExiste()
    {
        File file = context.getFileStreamPath(fileNameBuilding);
        return file.exists();
    }

    /**
     * delete json JsonBuilding file
     */
    public static void deleteJson()
    {
        Log.d("debug", "delete...");
        File file = context.getFileStreamPath(fileNameBuilding);
        file.delete();
    }

    /**
     * init the jsonBuilding file
     * create it if it doesn't exist on this phone
     *
     * @param mContext
     */
    public static void init(Context mContext){
        context = mContext;
        if(fichierExiste())
        {
            Log.d("debug", "le fichier existe deja");
            //deleteJson();
            //init(mContext);
        } else {
            Log.d("debug", "Création du fichier");
            addBuildings();
        }
    }

    /**
     * delete the current JsonBuilding file
     * create a new JsonBuilding file with initial building
     *
     * @param mContext
     */
    public static void recreate(Context mContext){
        context = mContext;
        deleteJson();
        init(mContext);
    }

    /**
     * Add initial buildings to JsonBuilding file
     */
    public static void addBuildings(){
        writeText("{\n" +
                "  \"buildings\": [\n" +
                "    {\n" +
                "      \"name\": \"Piste cyclable\",\n" +
                "      \"description\": \"Voie réservée aux cyclistes et protégée du reste de la circulation\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 3,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 0,\n" +
                "        \"fluidite\": 1,\n" +
                "        \"environnemental\": 1\n" +
                "      },\n" +
                "      \"scoreLogistique\": 2,\n" +
                "      \"explicationLogistique\": \"Toute la voie étant protégée de la circulation, cet aménagement crée un obstacle pour la livraison en limitant l'accès au trottoir.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Borne vélo\",\n" +
                "      \"description\": \"Borne permettant d'emprunter un vélo en libre service\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 1\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 1,\n" +
                "        \"fluidite\": -1,\n" +
                "        \"environnemental\": 1\n" +
                "      },\n" +
                "      \"scoreLogistique\": -1,\n" +
                "      \"explicationLogistique\": \"Ces structures créent des obstacles ponctuels pour la livraison en limitant l'accès au trottoir.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Terrasse\",\n" +
                "      \"description\": \"Terasse de café ou de restaurant\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 1\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 1,\n" +
                "        \"fluidite\": -2,\n" +
                "        \"environnemental\": 1\n" +
                "      },\n" +
                "      \"scoreLogistique\": -3,\n" +
                "      \"explicationLogistique\": \"Cet aménagement limite l'accès à l'établissement tout en empiétant sur le trottoir et sur le stationnement.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Petit magasin\",\n" +
                "      \"description\": \"Petit commerce (-20 salariés)\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 4,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 2,\n" +
                "        \"fluidite\": 1,\n" +
                "        \"environnemental\": 0\n" +
                "      },\n" +
                "      \"scoreLogistique\": -1,\n" +
                "      \"explicationLogistique\": \"Cet aménagement génère du trafic de marchandises : livraisons et déplacement d'achats.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Poste\",\n" +
                "      \"description\": \"Bureau de poste\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 1,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 0,\n" +
                "        \"fluidite\": 2,\n" +
                "        \"environnemental\": -1\n" +
                "      },\n" +
                "      \"scoreLogistique\": 1,\n" +
                "      \"explicationLogistique\": \"Cet aménagement permet la livraison des colis en l'absence des destinataires, les flux sont donc consolidés, mais les horaires d'ouverture sont restreints.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Grand magasin\",\n" +
                "      \"description\": \"Supermarché ou grande surface spécialisée(+ de 20 salariés)\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 6,\n" +
                "        \"economique\": 3\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 5,\n" +
                "        \"fluidite\": -2,\n" +
                "        \"environnemental\": -1\n" +
                "      },\n" +
                "      \"scoreLogistique\": -2,\n" +
                "      \"explicationLogistique\": \"Ce lieu génère du trafic de marchandises : livraisons et déplacements d'achats.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Zone de rencontre\",\n" +
                "      \"description\": \"Une zone de rencontre est une zone apaisée où la vitesse est limitée à 20km/h, sans trottoirs où tous les usagers de la voirie oeuvent se croiser(vélo, autos, piétons, camions, etc.)\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 1,\n" +
                "        \"fluidite\": -1,\n" +
                "        \"environnemental\": 2\n" +
                "      },\n" +
                "      \"scoreLogistique\": 0,\n" +
                "      \"explicationLogistique\": \"L'absence de trottoires facilite l'accès aux établissements pour les véhicules de livraisons, mais la vitesse limitée réduit l'accessibilité.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Réseau de consignes\",\n" +
                "      \"description\": \"Un réseau de consignes automatiques est composé de boites sécurisées permettant le retrait de colis à toute heure\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 3,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 0,\n" +
                "        \"fluidite\": 2,\n" +
                "        \"environnemental\": 0\n" +
                "      },\n" +
                "      \"scoreLogistique\": 2,\n" +
                "      \"explicationLogistique\": \"Accessible à toute heure, cet aménagement permet la livraison des colis en l'absence des destinataires. Il limite le nombre de véhicules de livraisons grâce à la consolidation permises.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Dispositif anti-bélier\",\n" +
                "      \"description\": \"Plots en béton disposés devant les batiments pour éviter l'usage de voiture-bélier\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 1,\n" +
                "        \"economique\": 1\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 1,\n" +
                "        \"fluidite\": -2,\n" +
                "        \"environnemental\": 0\n" +
                "      },\n" +
                "      \"scoreLogistique\": -2,\n" +
                "      \"explicationLogistique\": \"Ce système interdit l'accès des véhicules aux établissements économiques et aux logements des particuliers.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Aire de livraison\",\n" +
                "      \"description\": \"Emplacement réservé à l'arrêt des véhicules pour réaliser une livraison ou un enlèvement de marchandise\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 1,\n" +
                "        \"economique\": 3\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": -1,\n" +
                "        \"fluidite\": 2,\n" +
                "        \"environnemental\": -1\n" +
                "      },\n" +
                "      \"scoreLogistique\": 1,\n" +
                "      \"explicationLogistique\": \"Cet aménagement offre aux véhicules de livraison la possibilité de stationner. Tout en décongestionnant la voirie, il facilite le travail du livreur.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"CDU\",\n" +
                "      \"description\": \"Un Centre de Distribution Urbaine est un entrepôt situé en ville qui facilite les livraisons\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 3\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": -1,\n" +
                "        \"fluidite\": 4,\n" +
                "        \"environnemental\": 2\n" +
                "      },\n" +
                "      \"scoreLogistique\": 1,\n" +
                "      \"explicationLogistique\": \"Cet aménagement permet la mutualisation des flux des particuliers et des activités. La livraison finale est réalisée avec des véhicules propres. Peut s'articuler avec les autres espaces logistiques (PAV, consignes).\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"PAV\",\n" +
                "      \"description\": \"Un Point d'Accueil des Véhicules est une grande aire de livraison équipée de moyens de manutention à la disposition des livreurs\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": -3,\n" +
                "        \"fluidite\": 4,\n" +
                "        \"environnemental\": -1\n" +
                "      },\n" +
                "      \"scoreLogistique\": 2,\n" +
                "      \"explicationLogistique\": \"Le stationnement et la manutention sont facilités. La livraison est donc plus efficace et les conditions de travail du chauffeur améliorées.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Station GAZ GNV\",\n" +
                "      \"description\": \"Station de recharge au gaz naturel utilisée pour recharger des camions plus propres\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 3,\n" +
                "        \"economique\": 2\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": -1,\n" +
                "        \"fluidite\": 0,\n" +
                "        \"environnemental\": 2\n" +
                "      },\n" +
                "      \"scoreLogistique\": 1,\n" +
                "      \"explicationLogistique\": \"Ce dispositif permet aux véhicules au gaz de se recharger et aux transporteurs de rouler même lors des pics de pollution.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Banc\",\n" +
                "      \"description\": \"2 bancs\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 1,\n" +
                "        \"social\": 1,\n" +
                "        \"economique\": 1\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 0,\n" +
                "        \"fluidite\": -1,\n" +
                "        \"environnemental\": 1\n" +
                "      },\n" +
                "      \"scoreLogistique\": -1,\n" +
                "      \"explicationLogistique\": \"Cet aménagement  constitue un obstacle ponctuel pour la livraison en limitant l'accès au trottoir.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Zone végétalisée\",\n" +
                "      \"description\": \"Espace vert\",\n" +
                "      \"Couts\": {\n" +
                "        \"politique\": 2,\n" +
                "        \"social\": 2,\n" +
                "        \"economique\": 1\n" +
                "      },\n" +
                "      \"Effets\": {\n" +
                "        \"attractivite\": 1,\n" +
                "        \"fluidite\": -4,\n" +
                "        \"environnemental\": 4\n" +
                "      },\n" +
                "      \"scoreLogistique\": -2,\n" +
                "      \"explicationLogistique\": \"Cette zone, non franchissables avec des outils de manutention, gêne la livraison.\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    /**
     *Fonction qui lit le fichier Joson
     * renvoie une chaine de caractere contenant le fichier JSON
     * @return String
     * @throws IOException
     */
    public static String readText() throws IOException {
        File file = context.getFileStreamPath(fileNameBuilding);
        if (!file.exists()){
            return "fichier inexistant";
        }
        else{
            InputStream is = context.openFileInput(fileNameBuilding);
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

    /**
     * write a string into real file on phone
     *
     * @param data
     */
    public static void writeText(String data){
        FileOutputStream fOut = null;
        OutputStreamWriter osw = null;
        try{
            fOut = context.openFileOutput(fileNameBuilding, Context.MODE_PRIVATE);
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

    /**
     * read the JsonBuilding file
     * return all buildings
     *
     * @return Arraylist<Building>
     */
    public static ArrayList<Building> readBuilding(){
        Log.d("debug", "readBuilding...");
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonBuildings = null;
        JSONObject jsonBuilding = null;
        JSONObject jsonCouts;
        JSONObject jsonEffets;
        ArrayList<Building> listeBuilding = new ArrayList<>();
        try {
            jsonText = readText();
            jsonRoot = new JSONObject(jsonText);
            jsonBuildings = jsonRoot.getJSONArray("buildings");
            for(int i=0; i<jsonBuildings.length(); i++){
                jsonBuilding = jsonBuildings.getJSONObject(i);
                String name = jsonBuilding.getString("name");
                String description = jsonBuilding.getString("description");
                jsonCouts = jsonBuilding.getJSONObject("Couts");
                int coutPolitique= Integer.parseInt(jsonCouts.getString("politique"));
                int coutSocial= Integer.parseInt(jsonCouts.getString("social"));
                int coutEconomique= Integer.parseInt(jsonCouts.getString("economique"));
                jsonEffets = jsonBuilding.getJSONObject("Effets");
                int effetAttractivite = Integer.parseInt(jsonEffets.getString("attractivite"));
                int effetFluidite = Integer.parseInt(jsonEffets.getString("fluidite"));
                int effetEnvironnemental = Integer.parseInt(jsonEffets.getString("environnemental"));
                int scoreLogistique = jsonBuilding.getInt("scoreLogistique");
                String explicationLogistique = jsonBuilding.getString("explicationLogistique");
                Building building = new Building(name, description, coutPolitique, coutSocial, coutEconomique, effetAttractivite, effetFluidite, effetEnvironnemental, scoreLogistique, explicationLogistique);
                listeBuilding.add(building);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return listeBuilding;
    }

    /**
     * Mofication of a building in the json File
     *
     * @param building
     * @param name
     */
    public static void modificationBuilding(Building building, String name){
        Log.d("debug", "modificationBuilding...");
        removeBuilding(name);
        writeBuilding(building);
    }


    /**
     * Write building in Json File
     *
     * @param building
     */
    public static void writeBuilding(Building building){
        Log.d("debug", "writeBuilding...");
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonBuildings = null;
        try {
            JSONObject object = new JSONObject();
            object.put("name", building.getName());
            object.put("description", building.getDescription());
            JSONObject couts = new JSONObject();
            couts.put("politique", building.getCoutPolitique());
            couts.put("social", building.getCoutSocial());
            couts.put("economique", building.getCoutEconomique());
            object.put("Couts", couts);
            JSONObject effets = new JSONObject();
            effets.put("attractivite", building.getEffetAttractivite());
            effets.put("fluidite", building.getEffetFluidite());
            effets.put("environnemental", building.getEffetEnvironnemental());
            object.put("Effets", effets);

            object.put("scoreLogistique", building.getScoreLogistique());
            object.put("explicationLogistique", building.getExplicationLogistique());

            jsonText = readText();
            jsonRoot = new JSONObject(jsonText);
            jsonBuildings = jsonRoot.getJSONArray("buildings");
            jsonBuildings.put(object);
            Log.d("debug", jsonBuildings.toString());
            writeText(jsonRoot.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * remove a Building from Json file with the name of the building
     * check in all the file if it exist
     *
     * @param name
     */
    public static void removeBuilding(String name){
        Log.d("debug", "removeBuilding...");
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonBuildings = null;
        JSONObject jsonBuilding = null;
        try {
            jsonText = readText();
            jsonRoot = new JSONObject(jsonText);
            jsonBuildings = jsonRoot.getJSONArray("buildings");
            for(int i=0; i<jsonBuildings.length(); i++){
                jsonBuilding = jsonBuildings.getJSONObject(i);
                if((jsonBuilding.getString("name").replaceAll("([A-Z])", "$1").toLowerCase()).equals(name.replaceAll("([A-Z])", "$1").toLowerCase())){
                    Log.d("debug", "==> " + i);
                    jsonBuildings.remove(i);
                }
            }
            writeText(jsonRoot.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * check if a building exist in the json file
     * with the name of the building
     *
     * @param name
     * @return
     */
    public static boolean buildingAlreadyInList(String name){
        Log.d("debug", "buildingAlreadyInList...");
        String jsonText = null;
        JSONObject jsonRoot = null;
        JSONArray jsonBuildings = null;
        JSONObject jsonBuilding = null;
        try {
            jsonText = readText();
            jsonRoot = new JSONObject(jsonText);
            jsonBuildings = jsonRoot.getJSONArray("buildings");
            for(int i=0; i<jsonBuildings.length(); i++){
                jsonBuilding = jsonBuildings.getJSONObject(i);

                if((jsonBuilding.getString("name").replaceAll("([A-Z])", "$1").toLowerCase()).equals(name.replaceAll("([A-Z])", "$1").toLowerCase()) || (jsonBuilding.getString("name").replaceAll("([A-Z])", "$1").toLowerCase()).equals(name.replaceAll("([A-Z])", "$1").toLowerCase())){
                    return true;
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
