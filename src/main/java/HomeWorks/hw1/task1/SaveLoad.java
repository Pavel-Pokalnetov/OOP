package HomeWorks.hw1.task1;

/**
 * Класс записи и загрузки данных в файл
 */
class SaveLoad {
    GeoTree tree;
    public SaveLoad(GeoTree geoTree) {
        tree = geoTree;
    }

    /** Загрузка даных из файла
     * @param fileName - имя файла для загрузки
     * @return - полученный из файла объект GeoTree
     */
    public GeoTree load(String fileName) {
        /* Здесь считываем данные из файла fileName
         * для последующего парсинга и записи данных в GeoTree tree
         * возвращаем tree*/
        return this.tree;
    }

    /** Запись данных в файл
     * @param fileName - имя файла для записи
     * @return - результат записи
     */
    public boolean save(String fileName) {
        boolean result = false;
        /* Здесь формируем сериализованную структуру данных из GeoTree tree
         * и записываем в файл с именем fileName
         * и возвращаем результат записи
         * */
        return result;
    }
}

