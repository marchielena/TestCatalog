package MarchiElena;

/*
    *
 */

public class App {

    public static void main(String[] args) {

        String article = "ladder";
        String s = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n" +
                "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n" +
                "<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>\n" +
                "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n" +
                "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>\n" +
                "<prod><name>chair</name><prx>100</prx><qty>20</qty></prod>\n" +
                "<prod><name>fan</name><prx>50</prx><qty>8</qty></prod>\n" +
                "<prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>\n" +
                "<prod><name>battery</name><prx>150</prx><qty>12</qty></prod>\n" +
                "<prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>\n" +
                "<prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>\n" +
                "<prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>\n" +
                "<prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>\n" +
                "<prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>\n" +
                "<prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>\n" +
                "<prod><name>platform</name><prx>65</prx><qty>21</qty></prod>\n" +
                "<prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>\n" +
                "<prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>\n" +
                "<prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>\n" +
                "<prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>\n" +
                "<prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>\n" +
                "<prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>\n" +
                "<prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>\n" +
                "<prod><name>cattle prod</name><prx>990</prx><qty>2</qty></prod>è\n" +
                "<prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>";
        System.out.println(catalog(s, article));
    }

    public static String catalog(String s, String article) {
        String catalog = "";
        if (!s.contains(article)) {
            return "Nothing";
        } else {
            String[] articles = s.split("\n");
            for (int i = 0; i < articles.length; i++) {
                if (articles[i].contains(article)) {
                    catalog += articles[i];
                    catalog = catalogForm(catalog);
                    catalog = catalog + "\n";
                }
            }
            catalog = catalog.substring(0, catalog.length() - 1);
            return catalog;
        }
    }

    public static String catalogForm(String catalog) {
        String purge[] = {"<prod>", "<name>", "</prx>", "</qty>", "</prod>", "</name>"};
        String result = catalog;
        result = result.replace("<prx>", " > prx: $");
        result = result.replace("<qty>", " qty: ");
        for (int i = 0; i < purge.length; ++i) {
            result = result.replace(purge[i], "");
        }
        return result;
    }
}