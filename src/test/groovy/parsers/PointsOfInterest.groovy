package parsers

class PointsOfInterest implements GaiaParser {

    private def data
    private List poiList = []

    PointsOfInterest(def data) {
        this.data = data
        setPoiList()
    }

    private void setPoiList() {
        for (it in data)
            poiList.add(it.localizedNames.value.get(0))
    }

    List getList() {
        this.poiList
    }
}