package parsers

class NearbyCities implements GaiaParser{

    private def data
    private List nearbyCitiesList = []

    NearbyCities(def data) {
        this.data = data
        setNearbyCitiesList()
    }

    private void setNearbyCitiesList() {
        for (it in data)
            nearbyCitiesList.add(it.localizedNames.value.get(0))
    }

    List getList() {
        this.nearbyCitiesList
    }
}