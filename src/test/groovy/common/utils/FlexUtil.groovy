package common.utils

/**
 * Created by rokulkarni on 9/13/16.
 */
public class FlexUtil {

    private static posLocaleTpid = [
            'ORB.en_US'  : '70201-en_US',
            'CTIX.en_US' : '70301-en_US',
            'EBUK.en_GB' : '70403-en_GB',
            'EBCH.de_CH' : '70472-de_CH',
            'EBCH.en_GB' : '70472-en_GB',
            'EBCH.fr_CH' : '70472-fr_CH',
            'EBFI.fi_FI' : '70473-fi_FI',
            'EBFI.en_GB' : '70473-en_GB',
            'EBDE.de_DE' : '70406-de_DE',
            'EBFR.fr_FR' : '70420-fr_FR',
            'EBIE.en_IE' : '70463-en_IE',
            'EXP.en_US'  : '1-en_US',
            'EXP.en_GB'  : '3-en_GB',
            'EXP.en_AU'  : '25-en_AU',
            'EXP.en_CA'  : '4-en_CA',
            'MJSE.sv_SE' : '70465-sv_SE',
            'WTF.en_AU'  : '70125-en_AU',
            'EXPIE.en_IE': '63-en_IE',
            'EXPNZ.en_AU': '29-en_AU',
            'EXPES.es_ES': '9-es_ES',
            'EXPFR.fr_FR': '20-fr_FR',
            'EXPIT.it_IT': '8-it_IT',
            'TVLY.en_US' : '80001-en_US',
            'EXP.es_MX'  : '1-es_MX',
            'EXP.zh_CN'  : '1-zh_CN'
    ]


    static String getTpidFromPosLocale(String posLocale) {
        return posLocaleTpid[posLocale]
    }

}