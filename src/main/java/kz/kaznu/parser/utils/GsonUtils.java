package kz.kaznu.parser.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import kz.kaznu.parser.constants.Constants;
import kz.kaznu.parser.models.Company;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class GsonUtils {
    public static List<Company> readCompaniesFromFile() throws FileNotFoundException {
        Type type = new TypeToken<List<Company>>(){}.getType();
        JsonReader jsonReader = new JsonReader(new FileReader(Constants.COMPANIES_JSON_FILE));
        return new Gson().fromJson(jsonReader, type);
    }
}
