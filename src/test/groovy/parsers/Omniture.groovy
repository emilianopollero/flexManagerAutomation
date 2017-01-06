package parsers

class Omniture {

    String pageName
    String channel
    String prop2
    String prop3
    String prop4
    String eVar2
    String eVar3
    String eVar4
    String prop58

    Omniture(def json) {
        pageName = json.omnitureProperties.pageName
        channel = json.omnitureProperties.channel
        prop2 = json.omnitureProperties.prop2
        prop3 = json.omnitureProperties.prop3
        prop4 = json.omnitureProperties.prop4
        eVar2 = json.omnitureProperties.eVar2
        eVar3 = json.omnitureProperties.eVar3
        eVar4 = json.omnitureProperties.eVar4
        prop58 = json.omnitureProperties.prop58
    }

    String getPageName() {
        this.pageName
    }

    String getChannel() {
        this.channel
    }

    String getProp2() {
        this.prop2
    }

    String getProp3() {
        this.prop3
    }

    String getProp4() {
        this.prop4
    }

    String getEVar2() {
        this.eVar2
    }

    String getEVar3() {
        this.eVar3
    }

    String getEVar4() {
        this.eVar4
    }

    String getOrop58() {
        this.prop58
    }
}