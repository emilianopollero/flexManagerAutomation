package modules

import geb.Module

class PosLocaleModule extends Module {
    static content = {
        mappingDropdown { $('#container > table > thead > tr:nth-child(1) > th > div > select:nth-child(2)') }
        templateDropdown { $('#container > table > thead > tr:nth-child(1) > th > div > select') }
        //PosLocale dropdown Options
        orbEnUs { $('option', label: "ORB.en_US") }
        ctixEnUs { $('option', label: "CTIX.en_US") }
        ebukEnGb { $('option', label: "EBUK.en_GB") }
        ebchDeCh { $('option', label: "EBCH.de_CH") }
        ebchEnGb { $('option', label: "EBCH.en_GB") }
        ebchFrCh { $('option', label: "EBCH.fr_CH") }
        ebfiFiFi { $('option', label: "EBFI.fi_FI") }
        ebfiEnGb { $('option', label: "EBFI.en_GB") }
        ebdeDeDe { $('option', label: "EBDE.de_DE") }
        ebfrFrFr { $('option', label: "EBFR.fr_FR") }
        ebieEnIE { $('option', label: "EBIE.en_IE") }
        expEnUS { $('option', label: "EXP.en_US") }
        expEnGB { $('option', label: "EXP.en_GB") }
        expEnAU { $('option', label: "EXP.en_AU") }
        expEnCA { $('option', label: "EXP.en_CA") }
        expEsMX { $('option', label: "EXP.es_MX") }
        expZhCN { $('option', label: "EXP.zh_CN") }
        mjseSvSe { $('option', label: "MJSE.sv_SE") }
        wtfEnAu { $('option', label: "WTF.en_AU") }
        expieEnIE { $('option', label: "EXPIE.en_IE") }
        expnzEnAu { $('option', label: "EXPNZ.en_AU") }
        expesEsEs { $('option', label: "EXPES.es_ES") }
        expfrFrFr { $('option', label: "EXPFR.fr_FR") }
        expitItIt { $('option', label: "EXPIT.it_IT") }
        tvlyEnUs { $('option', label: "TVLY.en_US") }
    }

    def checkUIElements() {
        assert orbEnUs
        assert ctixEnUs
        assert ebukEnGb
        assert ebchDeCh
        assert ebchEnGb
        assert ebchFrCh
        assert ebfiFiFi
        assert ebfiEnGb
        assert ebdeDeDe
        assert ebfrFrFr
        assert ebieEnIE
        assert expEnUS
        assert expEnGB
        assert expEnAU
        assert expEnCA
        assert expEsMX
        assert expZhCN
        assert mjseSvSe
        assert wtfEnAu
        assert expieEnIE
        assert expnzEnAu
        assert expesEsEs
        assert expfrFrFr
        assert expitItIt
        assert tvlyEnUs
    }
}
