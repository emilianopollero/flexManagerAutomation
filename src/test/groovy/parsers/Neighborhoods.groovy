package parsers

class Neighborhoods implements GaiaParser{

    private def data
    private List neighborhoodsList = []

    Neighborhoods(def data) {
        this.data = data
        setNeighborhoodsList()
    }

    private void setNeighborhoodsList() {
        for (it in data) {
            String actualName= it.localizedNames.value.get(0)
            if ((it.tags.common!=null) &&
                ((it.tags.common.subClassification.value!= 'airport') &&
                (it.tags.common.subClassification.value!= 'city')))
                neighborhoodsList.add(actualName)
        }
    }

    List getList() {
        this.neighborhoodsList
    }
}