public class PreConditionTest {

//PreCondition Test: Verify list of url resolve successfully

    static String pageType
    static String env
    static String[] posList

    public static void main(String[] arg) {

        (arg.length >= 1) ? setPageType(arg[0]) : testError('Missing parameter')
        (arg.length >= 2) ? setEnvironment(arg[1]) : (env = 'prod')
        (arg.length >= 3) ? setPosList(arg[2]) : (posList = baseUrls[env].keySet())

        runPreconditionTest(pageType)
    }

    static void setPageType(String type) {
        String[] validPageTypes = urlList.keySet()
        if (validPageTypes.contains(type)) {
            this.pageType = type
        } else {
            testError('Invalid Page Type', type)
        }
    }

    static void setEnvironment(String environment) {
        if (['prod', 'lab'].contains(environment)) {
            this.env = environment
        } else {
            testError('Invalid Environment', environment)
        }
    }

    static void setPosList(String list) {
        if (list) {
            posList = list.replace('@', '').split(',')
            String[] validPOS = baseUrls[env].keySet()
            for (pos in posList) {
                if (!validPOS.contains(pos)) {
                    testError('Invalid POS', pos)
                }
            }
        } else {
            posList = baseUrls[env].keySet()
        }
    }

    static void testError(String error, String value = null) {
        switch (error) {
            case 'Missing parameter':
                println('\nError: Please select a pageType.\nChoose from the list:')
                urlList.findAll { it }.collect { println('- ' + it.key) }
                break
            case 'Invalid Page Type':
                println("\nError: ${value} is not a valid page type.\n\nSelect a page type from the list:\n")
                urlList.findAll { it }.collect { println('- ' + it.key) }
                break
            case 'Invalid Environment':
                println("\nError: ${value} is not a valid environment.\n\n Select an environment from the list:\n")
                baseUrls.findAll { it }.collect { println('- ' + it.key) }
                break
            case 'Invalid POS':
                println("\nError: ${value} is not a valid POS.\n\n Select an POS from the list:\n")
                baseUrls[env].findAll { it }.collect { println('- ' + it.key) }
                break
        }
        System.exit(1)
    }

    static Map baseUrls = [
            'lab' : ['ORB'    : 'http://wwworbitzcom.flex-web.us-west-2.test.expedia.com',
                     'CTIX'   : 'http://wwwcheapticketscom.flex-web.us-west-2.test.expedia.com',
                     'EBUK'   : 'http://wwwebookerscom.flex-web.us-west-2.test.expedia.com',
                     'EBCH'   : 'http://wwwebookersch.flex-web.us-west-2.test.expedia.com',
                     'EBCH_en': 'http://wwwebookersch.flex-web.us-west-2.test.expedia.com/en',
                     'EBCH_fr': 'http://wwwebookersch.flex-web.us-west-2.test.expedia.com/fr',
                     'EBFR'   : 'http://wwwebookersfr.flex-web.us-west-2.test.expedia.com',
                     'EBDE'   : 'http://wwwebookersde.flex-web.us-west-2.test.expedia.com',
                     'EBIE'   : 'http://wwwebookersie.flex-web.us-west-2.test.expedia.com',
                     'EBFI'   : 'http://wwwebookersfi.flex-web.us-west-2.test.expedia.com',
                     'EBFI_en': 'http://wwwebookersfi.flex-web.us-west-2.test.expedia.com/en',
                     'MJSE'   : 'http://wwwmrjetse.flex-web.us-west-2.test.expedia.com',
            ],
            'prod': ['ORB'    : 'https://www.orbitz.com',
                     'CTIX'   : 'https://www.cheaptickets.com',
                     'EBUK'   : 'https://www.ebookers.com',
                     'EBCH'   : 'https://www.ebookers.ch',
                     'EBCH_en': 'https://www.ebookers.ch/en',
                     'EBCH_fr': 'https://www.ebookers.ch/fr',
                     'EBFR'   : 'https://www.ebookers.fr',
                     'EBDE'   : 'https://www.ebookers.de',
                     'EBIE'   : 'https://www.ebookers.ie',
                     'EBFI'   : 'https://www.ebookers.fi',
                     'EBFI_en': 'https://www.ebookers.fi/en',
                     'MJSE'   : 'https://www.mrjet.se',
            ],
    ]

    //Add here a url for each tpid for every page type

    static Map urlList = ['TravelGuideFlights'                : [['tpid': 'ORB', 'uri': '/Cheap-Flights-To-Chicago.d178248.Travel-Guide-Flights'],
                                                                 ['tpid': 'CTIX', 'uri': '/Cheap-Flights-To-Chicago.d178248.Travel-Guide-Flights'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Cheap-Flights-To-Zurich.d178320.Travel-Guide-Flights'],
                                                                 ['tpid': 'EBCH', 'uri': '/Billigflug-Zurich.d178320.Reise-Angebote-Flug'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vols-Pas-Cher-Paris.d179898.Voyage-Guide-Vols'],
                                                                 ['tpid': 'EBDE', 'uri': '/Billigflug-Helsinki.d178261.Reise-Angebote-Flug'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Cheap-Flights-To-Dublin.d178256.Travel-Guide-Flights'],
                                                                 ['tpid': 'EBFI', 'uri': '/Halvat-Lennot-Lontoo.d178279.Matkaopas-Lennot'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vols-Pas-Cher-Paris.d179898.Voyage-Guide-Vols'],
                                                                 ['tpid': 'EBIE', 'uri': '/Cheap-Flights-To-Zurich.d178320.Travel-Guide-Flights'],
                                                                 ['tpid': 'EBUK', 'uri': '/Cheap-Flights-To-London.d178279.Travel-Guide-Flights'],
                                                                 ['tpid': 'MJSE', 'uri': '/Flyg-Till-Kopenhamn.d178252.Reseguide-Flyg']],
                          'TravelGuideCarRentalCompany'       : [['tpid': 'ORB', 'uri': '/Dollar-Rent-A-Car-Car-Rental.cZR.Travel-Guide-CarRentalCompany'],
                                                                 ['tpid': 'CTIX', 'uri': '/Dollar-Rent-A-Car-Car-Rental.cZR.Travel-Guide-CarRentalCompany'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Avis-Car-Hire.cZI.Travel-Guide-CarRentalCompany'],
                                                                 ['tpid': 'EBCH', 'uri': '/Avis-Autovermietung.cZI.Reisefuehrer-Autovermieter'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Location-Voiture-Avis.cZI.Voyage-Guide-LocationVoitureSociete'],
                                                                 ['tpid': 'EBDE', 'uri': '/Avis-Autovermietung.cZI.Reisefuehrer-Autovermieter'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Avis-Car-Hire.cZI.Travel-Guide-CarRentalCompany'],
                                                                 ['tpid': 'EBFI', 'uri': '/Avis-Autonvuokraus.cZI.Matkaoppaat-autovuokraamo'],
                                                                 ['tpid': 'EBFR', 'uri': '/Location-Voiture-Avis.cZI.Voyage-Guide-LocationVoitureSociete'],
                                                                 ['tpid': 'EBIE', 'uri': '/Avis-Car-Rental.cZI.Travel-Guide-CarRentalCompany'],
                                                                 ['tpid': 'EBUK', 'uri': '/Avis-Car-Hire.cZI.Travel-Guide-CarRentalCompany'],
                                                                 ['tpid': 'MJSE', 'uri': '/Avis-Biluthyrning.cZI.Reseguide-Hyrbilsforetag']],
                          'TravelGuideAirlines'               : [['tpid': 'ORB', 'uri': '/British-Airways-Flights.cBA.Travel-Guide-Airlines'],
                                                                 ['tpid': 'CTIX', 'uri': '/British-Airways-Flights.cBA.Travel-Guide-Airlines'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/American-Airlines-Flights.cAA.Travel-Guide-Airlines'],
                                                                 ['tpid': 'EBCH', 'uri': '/American-Airlines-Fluege.cAA.Airline-Angebote'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/American-Airlines-Vol.cAA.Voyage-Guide-Compagnie-Souhaitee'],
                                                                 ['tpid': 'EBDE', 'uri': '/American-Airlines-Fluege.cAA.Airline-Angebote'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/American-Airlines-Flights.cAA.Travel-Guide-Airlines'],
                                                                 ['tpid': 'EBFI', 'uri': '/American-Airlines-Lennot.cAA.Matkaopas-Lentoyhtiot'],
                                                                 ['tpid': 'EBFR', 'uri': '/American-Airlines-Vol.cAA.Voyage-Guide-Compagnie-Souhaitee'],
                                                                 ['tpid': 'EBIE', 'uri': '/American-Airlines-Flights.cAA.Travel-Guide-Airlines'],
                                                                 ['tpid': 'EBUK', 'uri': '/American-Airlines-Flights.cAA.Travel-Guide-Airlines'],
                                                                 ['tpid': 'MJSE', 'uri': '/American-Airlines-Flyg.cAA.Reseguide-Flygbolag']],
                          'FlightOndCity'                     : [['tpid': 'ORB', 'uri': '/lp/flights/178279/179898/london-to-paris'],
                                                                 ['tpid': 'CTIX', 'uri': '/lp/flights/178279/179898/london-to-paris'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/lp/flights/178280/178279/los-angeles-to-london'],
                                                                 ['tpid': 'EBCH', 'uri': '/lp/fluege/178280/178279/von-los-angeles-nach-london'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/lp/vol/178280/178279/de-los-angeles-a-londres'],
                                                                 ['tpid': 'EBDE', 'uri': '/lp/fluege/178280/178279/von-los-angeles-nach-london'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/lp/flights/178280/178279/los-angeles-to-london'],
                                                                 ['tpid': 'EBFI', 'uri': '/lp/lennot/178280/178279/los-angeles-lontoo'],
                                                                 ['tpid': 'EBFR', 'uri': '/lp/vol/178280/178279/de-los-angeles-a-londres'],
                                                                 ['tpid': 'EBIE', 'uri': '/lp/flights/178280/178279/los-angeles-to-london'],
                                                                 ['tpid': 'EBUK', 'uri': '/lp/flights/178280/178279/los-angeles-to-london'],
                                                                 ['tpid': 'MJSE', 'uri': '/lp/flyg/178280/178279/fran-los-angeles-till-london']],
                          'FlightOriginCity'                  : [['tpid': 'ORB', 'uri': '/lp/flights/178279/flights-from-london'],
                                                                 ['tpid': 'CTIX', 'uri': '/lp/flights/178279/flights-from-london'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/lp/flights/178280/flights-from-los-angeles'],
                                                                 ['tpid': 'EBCH', 'uri': '/lp/fluege/178280/fluege-von-los-angeles'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/lp/vol/178280/depart-los-angeles'],
                                                                 ['tpid': 'EBDE', 'uri': '/lp/fluege/178280/fluege-von-los-angeles'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/lp/flights/178280/flights-from-los-angeles'],
                                                                 ['tpid': 'EBFI', 'uri': '/lp/lennot/178280/lennot-kohteesta-los-angeles'],
                                                                 ['tpid': 'EBFR', 'uri': '/lp/vol/178280/depart-los-angeles'],
                                                                 ['tpid': 'EBIE', 'uri': '/lp/flights/178280/flights-from-los-angeles'],
                                                                 ['tpid': 'EBUK', 'uri': '/lp/flights/178280/flights-from-los-angeles'],
                                                                 ['tpid': 'MJSE', 'uri': '/lp/flyg/178280/flyg-fran-los-angeles']],
                          'HotelDestinationsCountry'          : [['tpid': 'ORB', 'uri': '/Destinations-In-United-States-Of-America.d201.Hotel-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-United-States-Of-America.d201.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Hotels-In-United-States-Of-America.d201.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Hotel-USA.d201.Hotel-Ziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotel-Etats-Unis-DAmerique.d201.Destinations-hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Hotel-USA.d201.Hotel-Ziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Hotels-In-United-States-Of-America.d201.Hotel-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Hotellit-Yhdysvallat.d201.Hotellit-kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotel-Etats-Unis-DAmerique.d201.Destinations-hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/Hotels-In-France.d59.Hotel-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Hotels-In-United-States-Of-America.d201.Hotel-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/USA-Hotell.d201.Resmal-med-hotell']],
                          'HotelDestinationsState'            : [['tpid': 'ORB', 'uri': '/Destinations-In-California.d206.Hotel-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-California.d206.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Hotels-In-Illinois.d215.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Hotel-Illinois.d215.Hotel-Ziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotel-Illinois.d215.Destinations-hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Hotel-Illinois.d215.Hotel-Ziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Hotels-In-Illinois.d215.Hotel-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Hotellit-Illinois.d215.Hotellit-kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotel-Illinois.d215.Destinations-hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/Hotels-In-Illinois.d215.Hotel-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Hotels-In-Illinois.d215.Hotel-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Illinois-Hotell.d215.Resmal-med-hotell']],
                          'HotelDestinationsContinent'        : [['tpid': 'ORB', 'uri': '/Destinations-In-North-America.d500001.Hotel-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-North-America.d500001.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Hotels-In-Europe.d6022967.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Hotel-Europa.d6022967.Hotel-Ziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotel-Europe.d6022967.Destinations-hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Hotel-Europa.d6022967.Hotel-Ziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Hotels-In-Europe.d6022967.Hotel-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Hotellit-Eurooppa.d6022967.Hotellit-kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotel-Europe.d6022967.Destinations-hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/Hotels-In-Europe.d6022967.Hotel-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Hotels-In-Europe.d6022967.Hotel-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Asien-Hotell.d6023099.Resmal-med-hotell']],
                          'HotelDestinationsMultiRegion'      : [['tpid': 'ORB', 'uri': '/Destinations-In-South-Central-Nevada.d6054236.Hotel-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-South-Central-Nevada.d6054236.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Hotels-In-Southern-Ontario.d6210011.Hotel-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Hotel-Ontario-Sud.d6210011.Hotel-Ziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotel-Ontorio-Sud.d6210011.Destinations-hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Hotel-Ontario-Sud.d6210011.Hotel-Ziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Hotels-In-Southern-Ontario.d6210011.Hotel-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Hotellit-Etela-Ontario.d6210011.Hotellit-kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotel-Ontorio-Sud.d6210011.Destinations-hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/Hotels-In-Southern-Ontario.d6210011.Hotel-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Hotels-In-Southern-Ontario.d6210011.Hotel-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Southern-Ontario-Hotell.d6210011.Resmal-med-hotell']],
                          'TravelGuideHotels'                 : [['tpid': 'ORB', 'uri': '/Las-Vegas-Hotels.d178276.Travel-Guide-Hotels'],
                                                                 ['tpid': 'CTIX', 'uri': '/Las-Vegas-Hotels.d178276.Travel-Guide-Hotels'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Chicago-Hotels.d178248.Travel-Guide-Hotels'],
                                                                 ['tpid': 'EBCH', 'uri': '/Hotel-Chicago.d178248.Reise-Angebote-Hotels'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotel-Chicago.d178248.Voyage-Guide-Hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Hotel-Chicago.d178248.Reise-Angebote-Hotels'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Chicago-Hotels.d178248.Travel-Guide-Hotels'],
                                                                 ['tpid': 'EBFI', 'uri': '/Chicago-Hotellit.d178248.Matkaoppaat-hotellit'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotel-Chicago.d178248.Voyage-Guide-Hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/Chicago-Hotels.d178248.Travel-Guide-Hotels'],
                                                                 ['tpid': 'EBUK', 'uri': '/Chicago-Hotels.d178248.Travel-Guide-Hotels'],
                                                                 ['tpid': 'MJSE', 'uri': '/Hotell-I-Chicago.d178248.Reseguide-Hotell']],
                          'HotelsNeighborhood'                : [['tpid': 'ORB', 'uri': '/Magnificent-Mile-Chicago-Hotels.0-n800025-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'CTIX', 'uri': '/Magnificent-Mile-Chicago-Hotels.0-n800025-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Magnificent-Mile-Chicago-Hotels.0-n800025-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH', 'uri': '/Magnificent-Mile-Ndash-River-North-Chicago-Hotels.0-n800025-0.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Magnificent-Mile-River-North-Chicago-Hotel.0-n800025-0.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Magnificent-Mile-Chicago-Hotel.0-n800025-0.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Magnificent-Mile-Chicago-Hotels.0-n800025-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBFI', 'uri': '/Magnificent-Mile-Chicago-Hotellit.0-n800025-0.Matkaoppaat-suodata-hotellit'],
                                                                 ['tpid': 'EBFR', 'uri': '/Magnificent-Mile-Chicago-Hotel.0-n800025-0.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/Magnificent-Mile-Chicago-Hotels.0-n800025-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBUK', 'uri': '/Magnificent-Mile-Chicago-Hotels.0-n800025-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'MJSE', 'uri': '/Magnificent-Mile-Chicago-Hotell.0-n800025-0.Reseguide-Filter-Hotell']],
                          'HotelsPOI'                         : [['tpid': 'ORB', 'uri': '/University-Of-Chicago-Hotels.0-l6064081-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'CTIX', 'uri': '/University-Of-Chicago-Hotels.0-l6064081-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/University-Of-Chicago-Hotels.0-l6064081-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH', 'uri': '/Universitat-Von-Chicago-Hotels.0-l6064081-0.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Universite-De-Chicago-Hotel.0-l6064081-0.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Universitat-Von-Chicago-Hotel.0-l6064081-0.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/University-Of-Chicago-Hotels.0-l6064081-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBFI', 'uri': '/University-Of-Chicago-Hotellit.0-l6064081-0.Matkaoppaat-suodata-hotellit'],
                                                                 ['tpid': 'EBFR', 'uri': '/Universite-De-Chicago-Hotel.0-l6064081-0.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/University-Of-Chicago-Hotels.0-l6064081-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBUK', 'uri': '/University-Of-Chicago-Hotels.0-l6064081-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'MJSE', 'uri': '/University-Of-Chicago-Hotell.0-l6064081-0.Reseguide-Filter-Hotell']],
                          'HotelsStarRating'                  : [['tpid': 'ORB', 'uri': '/5Star-Chicago-Hotels.s50-0-d178248.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'CTIX', 'uri': '/5Star-Chicago-Hotels.s50-0-d178248.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/5-Star-Hotels-In-Chicago.s50-0-d178248.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH', 'uri': '/5-Sterne-Hotels-In-Chicago.s50-0-d178248.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotel-5-Etoiles-Chicago.s50-0-d178248.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/5-Sterne-Hotels-In-Chicago.s50-0-d178248.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/5-Star-Hotels-In-Chicago.s50-0-d178248.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBFI', 'uri': '/5-Tahden-Chicago-Hotellit.s50-0-d178248.Matkaoppaat-suodata-hotellit'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotel-5-Etoiles-Chicago.s50-0-d178248.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/5-Star-Hotels-In-Chicago.s50-0-d178248.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBUK', 'uri': '/5-Star-Hotels-In-Chicago.s50-0-d178248.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'MJSE', 'uri': '/Femstjarnigt-Chicago-Hotell.s50-0-d178248.Reseguide-Filter-Hotell']],
                          'HotelsAirport'                     : [['tpid': 'ORB', 'uri': '/OHare-Intl-Airport-Hotels.0-aORD-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'CTIX', 'uri': '/OHare-Intl-Airport-Hotels.0-aORD-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/OHare-Intl-Airport-Hotels.0-aORD-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBCH', 'uri': '/Hotel-Flughafen-OHare-Intl.0-aORD-0.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Hotels-Aeroport-Aeroport-International-De-OHare.0-aORD-0.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBDE', 'uri': '/Hotel-Flughafen-OHare-Intl.0-aORD-0.Reise-Angebote-Filter-Hotels'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/OHare-Intl-Airport-Hotels.0-aORD-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBFI', 'uri': '/OHaren-Kansainvalinen-Lentokentta-lentokenttahotellit.0-aORD-0.Matkaoppaat-suodata-hotellit'],
                                                                 ['tpid': 'EBFR', 'uri': '/Hotels-Aeroport-Aeroport-International-De-OHare.0-aORD-0.Voyage-Guide-Filtre-Hotels'],
                                                                 ['tpid': 'EBIE', 'uri': '/OHare-Intl-Airport-Hotels.0-aORD-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'EBUK', 'uri': '/OHare-Intl-Airport-Hotels.0-aORD-0.Travel-Guide-Filter-Hotels'],
                                                                 ['tpid': 'MJSE', 'uri': '/Hotell-OHare-Intl-Flygplats.0-aORD-0.Reseguide-Filter-Hotell']],
                          'DestinationTravelGuidesCity'       : [['tpid': 'ORB', 'uri': '/London.d178279.Destination-Travel-Guides'],
                                                                 ['tpid': 'CTIX', 'uri': '/London.d178279.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/London-Holidays.d178279.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH', 'uri': '/London-Urlaub.d178279.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vacances-Londres.d178279.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBDE', 'uri': '/London-Reise.d178279.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/London-Holidays.d178279.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBFI', 'uri': '/Lontoo-Matkat.d178279.halvat-matkat-kaupunkiloma'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vacances-Londres.d178279.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBIE', 'uri': '/London-Holidays.d178279.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBUK', 'uri': '/London-Holidays.d178279.Destination-Travel-Guides'],
                                                                 ['tpid': 'MJSE', 'uri': '/London-Resor.d178279.Resor']],
                          'DestinationTravelGuidesCountry'    : [['tpid': 'ORB', 'uri': '/United-States-Of-America.d201.Destination-Travel-Guides'],
                                                                 ['tpid': 'CTIX', 'uri': '/United-States-Of-America.d201.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/United-States-Of-America-Holidays.d201.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH', 'uri': '/USA-Urlaub.d201.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vacances-Etats-Unis-DAmerique.d201.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBDE', 'uri': '/USA-Reise.d201.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/United-States-Of-America-Holidays.d201.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBFI', 'uri': '/Yhdysvallat-Matkat.d201.halvat-matkat-kaupunkiloma'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vacances-Etats-Unis-DAmerique.d201.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBIE', 'uri': '/United-States-Of-America-Holidays.d201.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBUK', 'uri': '/United-States-Of-America-Holidays.d201.Destination-Travel-Guides'],
                                                                 ['tpid': 'MJSE', 'uri': '/USA-Resor.d201.Resor']],
                          'DestinationTravelGuidesState'      : [['tpid': 'ORB', 'uri': '/Colorado.d207.Destination-Travel-Guides'],
                                                                 ['tpid': 'CTIX', 'uri': '/Colorado.d207.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Colorado-Holidays.d207.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH', 'uri': '/Colorado-Urlaub.d207.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vacances-Colorado.d207.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBDE', 'uri': '/Colorado-Reise.d207.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Colorado-Holidays.d207.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBFI', 'uri': '/Colorado-Matkat.d207.halvat-matkat-kaupunkiloma'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vacances-Colorado.d207.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBIE', 'uri': '/Colorado-Holidays.d207.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBUK', 'uri': '/Colorado-Holidays.d207.Destination-Travel-Guides'],
                                                                 ['tpid': 'MJSE', 'uri': '/Colorado-Resor.d207.Resor']],
                          'DestinationTravelGuidesContinent'  : [['tpid': 'ORB', 'uri': '/Europe.d6022967.Destination-Travel-Guides'],
                                                                 ['tpid': 'CTIX', 'uri': '/Europe.d6022967.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Europe-Holidays.d6022967.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH', 'uri': '/Europa-Urlaub.d6022967.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vacances-Europe.d6022967.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBDE', 'uri': '/Europa-Reise.d6022967.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Europe-Holidays.d6022967.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBFI', 'uri': '/Eurooppa-Matkat.d6022967.halvat-matkat-kaupunkiloma'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vacances-Europe.d6022967.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBIE', 'uri': '/Europe-Holidays.d6022967.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBUK', 'uri': '/Europe-Holidays.d6022967.Destination-Travel-Guides'],
                                                                 ['tpid': 'MJSE', 'uri': '/Europa-Resor.d6022967.Resor']],
                          'DestinationTravelGuidesMultiRegion': [['tpid': 'ORB', 'uri': '/Rio-De-Janeiro.d6052641.Destination-Travel-Guides'],
                                                                 ['tpid': 'CTIX', 'uri': '/Rio-De-Janeiro.d6052641.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Rio-De-Janeiro-Holidays.d6052641.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBCH', 'uri': '/Bundesstaat-Rio-De-Janeiro-Urlaub.d6052641.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vacances-Rio-De-Janeiro.d6052641.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBDE', 'uri': '/Bundesstaat-Rio-De-Janeiro-Reise.d6052641.Reise-Angebote-Staedtereisen'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Rio-De-Janeiro-Holidays.d6052641.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBFI', 'uri': '/Rio-De-Janeiro-Matkat.d6052641.halvat-matkat-kaupunkiloma'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vacances-Rio-De-Janeiro.d6052641.Reservation-Sejours-Voyages'],
                                                                 ['tpid': 'EBIE', 'uri': '/Rio-De-Janeiro-Holidays.d6052641.Destination-Travel-Guides'],
                                                                 ['tpid': 'EBUK', 'uri': '/Rio-De-Janeiro-Holidays.d6052641.Destination-Travel-Guides'],
                                                                 ['tpid': 'MJSE', 'uri': '/Rio-De-Janeiro-Resor.d6052641.Resor']],
                          'FlightDestinationsState'           : [['tpid': 'ORB', 'uri': '/Destinations-In-Illinois.d215.Flight-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-Illinois.d215.Flight-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Flights-To-Illinois.d215.Flight-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Fluege-Nach-Illinois.d215.Flugziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vols-Illinois.d215.Destinations-Vol'],
                                                                 ['tpid': 'EBDE', 'uri': '/Fluege-Nach-Illinois.d215.Flugziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Flights-To-Illinois.d215.Flight-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Lennot-Illinois.d215.Lennot-Kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vols-Illinois.d215.Destinations-Vol'],
                                                                 ['tpid': 'EBIE', 'uri': '/Flights-To-Illinois.d215.Flight-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Flights-To-Illinois.d215.Flight-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Flyg-Till-Illinois.d215.Resmal-med-flyg']],
                          'FlightDestinationsMultiRegion'     : [['tpid': 'ORB', 'uri': '/Destinations-In-Rio-De-Janeiro.d6052641.Flight-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-Rio-De-Janeiro.d6052641.Flight-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Flights-To-Rio-De-Janeiro.d6052641.Flight-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Fluege-Nach-Bundesstaat-Rio-De-Janeiro.d6052641.Flugziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vols-Rio-De-Janeiro.d6052641.Destinations-Vol'],
                                                                 ['tpid': 'EBDE', 'uri': '/Fluege-Nach-Bundesstaat-Rio-De-Janeiro.d6052641.Flugziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Flights-To-Rio-De-Janeiro.d6052641.Flight-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Lennot-Rio-De-Janeiro.d6052641.Lennot-Kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vols-Rio-De-Janeiro.d6052641.Destinations-Vol'],
                                                                 ['tpid': 'EBIE', 'uri': '/Flights-To-Rio-De-Janeiro.d6052641.Flight-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Flights-To-Rio-De-Janeiro.d6052641.Flight-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Flyg-Till-Rio-De-Janeiro.d6052641.Resmal-med-flyg']],
                          'FlightDestinationsCountry'         : [['tpid': 'ORB', 'uri': '/Destinations-In-France.d59.Flight-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-France.d59.Flight-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Flights-To-France.d59.Flight-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Fluege-Nach-Frankreich.d59.Flugziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vols-France.d59.Destinations-Vol'],
                                                                 ['tpid': 'EBDE', 'uri': '/Fluege-Nach-Frankreich.d59.Flugziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Flights-To-France.d59.Flight-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Lennot-Ranska.d59.Lennot-Kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vols-France.d59.Destinations-Vol'],
                                                                 ['tpid': 'EBIE', 'uri': '/Flights-To-France.d59.Flight-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Flights-To-France.d59.Flight-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Flyg-Till-Frankrike.d59.Resmal-med-flyg']],
                          'FlightDestinationsContinent'       : [['tpid': 'ORB', 'uri': '/Destinations-In-North-America.d500001.Flight-Destinations'],
                                                                 ['tpid': 'CTIX', 'uri': '/Destinations-In-North-America.d500001.Flight-Destinations'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/Flights-To-North-America.d500001.Flight-Destinations'],
                                                                 ['tpid': 'EBCH', 'uri': '/Fluege-Nach-Nordamerika.d500001.Flugziele'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/Vols-Amerique-Du-Nord.d500001.Destinations-Vol'],
                                                                 ['tpid': 'EBDE', 'uri': '/Fluege-Nach-Nordamerika.d500001.Flugziele'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/Flights-To-North-America.d500001.Flight-Destinations'],
                                                                 ['tpid': 'EBFI', 'uri': '/Lennot-Pohjois-Amerikka.d500001.Lennot-Kohteet'],
                                                                 ['tpid': 'EBFR', 'uri': '/Vols-Amerique-Du-Nord.d500001.Destinations-Vol'],
                                                                 ['tpid': 'EBIE', 'uri': '/Flights-To-North-America.d500001.Flight-Destinations'],
                                                                 ['tpid': 'EBUK', 'uri': '/Flights-To-North-America.d500001.Flight-Destinations'],
                                                                 ['tpid': 'MJSE', 'uri': '/Flyg-Till-Nordamerika.d500001.Resmal-med-flyg']],
                          'FlightOriginAirport'               : [['tpid': 'ORB', 'uri': '/lp/airports/ord/ohare-intl-airport'],
                                                                 ['tpid': 'CTIX', 'uri': '/lp/airports/ord/ohare-intl-airport'],
                                                                 ['tpid': 'EBCH_en', 'uri': '/lp/airports/ord/ohare-intl-airport'],
                                                                 ['tpid': 'EBCH', 'uri': '/lp/flughafen/ord/ohare-intl-airport'],
                                                                 ['tpid': 'EBCH_fr', 'uri': '/lp/aeroports/ord/aeroport-international-de-ohare-airport'],
                                                                 ['tpid': 'EBDE', 'uri': '/lp/flughafen/ord/ohare-intl-airport'],
                                                                 ['tpid': 'EBFI_en', 'uri': '/lp/airports/ord/ohare-intl-airport'],
                                                                 ['tpid': 'EBFI', 'uri': '/lp/lentokentat/ord/oharen-kansainvalinen-lentokentta-airport'],
                                                                 ['tpid': 'EBFR', 'uri': '/lp/aeroports/ord/aeroport-international-de-ohare-airport'],
                                                                 ['tpid': 'EBIE', 'uri': '/lp/airports/ord/ohare-intl-airport'],
                                                                 ['tpid': 'EBUK', 'uri': '/lp/airports/ord/ohare-intl-airport'],
                                                                 ['tpid': 'MJSE', 'uri': '/lp/flygplatser/ord/ohare-intl-airport']]


    ]

    static String getUrl(String tpid, String uri) {
        return (baseUrls[env][tpid] + uri)
    }

    static void runPreconditionTest(String pageType) {

        int testResult = 0
        String hopscotchCookies = 'forceroute_seo=xweb;forceroute_seven_site_takeover=xweb'
        String status

        println("\nPreCondition test begins ...\n")

        for (urlSet in urlList[pageType]) {

            String tpid = urlSet['tpid']

            //Test only pos on posList
            if (posList.contains(tpid)) {

                String uri = urlSet['uri']

                String url = getUrl(tpid, uri)

                if ((url.contains('ebookers') || url.contains('mrjet') && env.equals('prod'))) {
                    //Tpid in dark, cookies to enable hopscotch
                    def getUrlStatus = ['curl', '--cookie', hopscotchCookies, '-s', '-o', '/dev/null', '-w', '%{http_code}', url].execute()
                    getUrlStatus.waitFor()
                    status = getUrlStatus.text
                } else {
                    def getUrlStatus = ['curl', '-s', '-o', '/dev/null', '-w', '%{http_code}', url].execute()
                    getUrlStatus.waitFor()
                    status = getUrlStatus.text
                }

                if (!['200', '301'].contains(status)) {
                    println("Status Code: ${status} on url: ${url}")
                    testResult = 1
                }
            }
        }

        println("\nTest finished.\n")

        if (testResult == 0) {
            println("Completed successfully. ${pageType} pages status OK.\n")
        } else {
            println("Test failed. \nJenkins job will be interrupted.\n")

        }
        System.exit(testResult)
    }
}