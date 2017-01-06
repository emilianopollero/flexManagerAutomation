@MappingRegression @Regression @UI

Feature: Mapping regression

  Scenario: Open flex manager
    Given I open flex manager
    And I login with admin credentials
    And I click on the navigation bar mappingsDropdown and click on search

  Scenario Outline: User creates a mapping
    Given I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    And I click on the mappings list view page create button
    When I use these values <value1> and <value2> to fill in the required <mappingType> mapping type fields using this template <templateName>
    Then I can see mapping was created

# Valid mappingType values are:
#     Destination Travel Guides, Flight Ond Airport, Flight Ond City, Flight Origin Airport,  Flight Destinations, Flight Origin City, Hotel Destinations,
#     Travel Guide Flights, Travel Guide Hotels, Travel Guide Airlines, Travel Guide Car Rental Company, Travel Guide Filter Hotels, Url Mapping, Car Rental Guide,
#     Car Rental Destinations, Car Rental Guide Airport, Travel Guide Airports, Travel Guide Vacation Rentals
# Valid posLocale values are:
#     ORB.en_US, CTIX.en_US, EBUK.en_GB, EBCH.de_CH, EBCH.en_GB, EBCH.fr_CH, EBFI.fi_FI, EBFI.en_GB, EBDE.de_DE, EBFR.fr_FR,
#     EBIE.en_IE, EXP.en_US, EXP.en_GB, EXP.en_AU, EXP.en_CA, EXP.es_MX, EXP.zh_CN, MJSE.sv_SE, WTF.en_AU, EXPIE.en_IE, EXPNZ.en_AU, EXPES.es_ES,
#     EXPFR.fr_FR, EXPIT.it_IT, TVLY.en_US

    Examples:
      | posLocale   | mappingType                     | value1          | value2  | templateName                                   |
      | EXP.en_GB   | Destination Travel Guides       | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.en_AU   | Flight Ond Airport              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.en_CA   | Flight Ond City                 | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.es_MX   | Flight Ond City                 | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.zh_CN   | Flight Ond City                 | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | WTF.en_AU   | Flight Origin Airport           | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXPIE.en_IE | Flight Destinations             | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXPNZ.en_AU | Flight Origin City              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXPES.es_ES | Hotel Destinations              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXPFR.fr_FR | Travel Guide Flights            | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXPIT.it_IT | Travel Guide Hotels             | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | TVLY.en_US  | Travel Guide Airlines           | AeroGal         | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | ORB.en_US   | Destination Travel Guides       | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | CTIX.en_US  | Flight Ond Airport              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBUK.en_GB  | Flight Ond City                 | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBCH.de_CH  | Flight Origin Airport           | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBCH.en_GB  | Flight Destinations             | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBCH.fr_CH  | Flight Origin City              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBFI.fi_FI  | Hotel Destinations              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBFI.en_GB  | Travel Guide Flights            | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBDE.de_DE  | Travel Guide Hotels             | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBFR.fr_FR  | Travel Guide Airlines           | AeroGal         | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBIE.en_IE  | Travel Guide Car Rental Company | ACE Rent A Car  | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.en_US   | Travel Guide Filter Hotels      | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | MJSE.sv_SE  | Flight Ond Airport              | Las Vegas       | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.en_US   | Url Mapping                     | /testurlmapping | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | ORB.en_US   | Car Rental Guide                | La Plata        | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | CTIX.en_US  | Car Rental Destinations         | Kansas          | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBFR.fr_FR  | Car Rental Guide Airport        | Buenos Aires    | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBCH.fr_CH  | Travel Guide Airports           | Buenos Aires    | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.en_US   | Travel Guide Vacation Rentals   | Buenos Aires    | Chicago | automationMappingTestTemplatePolleroDoNotTouch |

  Scenario Outline: User publishes a mapping
    Given I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    When I publish mapping with template automationMappingTestTemplatePolleroDoNotTouch
    Then I check in flex-template-service mapping automationMappingTestTemplatePolleroDoNotTouch is present

    Examples:
      | posLocale   | mappingType                     |
      | EXP.en_GB   | Destination Travel Guides       |
      | EXP.en_AU   | Flight Ond Airport              |
      | EXP.en_CA   | Flight Ond City                 |
      | EXP.es_MX   | Flight Ond City                 |
      | EXP.zh_CN   | Flight Ond City                 |
      | WTF.en_AU   | Flight Origin Airport           |
      | EXPIE.en_IE | Flight Destinations             |
      | EXPNZ.en_AU | Flight Origin City              |
      | EXPES.es_ES | Hotel Destinations              |
      | EXPFR.fr_FR | Travel Guide Flights            |
      | EXPIT.it_IT | Travel Guide Hotels             |
      | TVLY.en_US  | Travel Guide Airlines           |
      | ORB.en_US   | Destination Travel Guides       |
      | CTIX.en_US  | Flight Ond Airport              |
      | EBUK.en_GB  | Flight Ond City                 |
      | EBCH.de_CH  | Flight Origin Airport           |
      | EBCH.en_GB  | Flight Destinations             |
      | EBCH.fr_CH  | Flight Origin City              |
      | EBFI.fi_FI  | Hotel Destinations              |
      | EBFI.en_GB  | Travel Guide Flights            |
      | EBDE.de_DE  | Travel Guide Hotels             |
      | EBFR.fr_FR  | Travel Guide Airlines           |
      | EBIE.en_IE  | Travel Guide Car Rental Company |
      | EXP.en_US   | Travel Guide Filter Hotels      |
      | MJSE.sv_SE  | Flight Ond Airport              |
      | EXP.en_US   | Url Mapping                     |
      | ORB.en_US   | Car Rental Guide                |
      | CTIX.en_US  | Car Rental Destinations         |
      | EBFR.fr_FR  | Car Rental Guide Airport        |
      | EBCH.fr_CH  | Travel Guide Airports           |
      | EXP.en_US   | Travel Guide Vacation Rentals   |

  Scenario Outline:  User deletes and cancels the delete of a mapping
    Given I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    When I delete and cancelDelete mapping with template name automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping automationMappingTestTemplatePolleroDoNotTouch is present

    Examples:
      | posLocale  | mappingType        |
      | MJSE.sv_SE | Flight Ond Airport |

  Scenario Outline: User deletes and confirms delete a mapping
    Given I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    When I delete and confirmDelete mapping with template name automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping automationMappingTestTemplatePolleroDoNotTouch is deleted

    Examples:
      | posLocale   | mappingType                     |
      | EXP.en_GB   | Destination Travel Guides       |
      | EXP.en_AU   | Flight Ond Airport              |
      | EXP.en_CA   | Flight Ond City                 |
      | EXP.es_MX   | Flight Ond City                 |
      | EXP.zh_CN   | Flight Ond City                 |
      | WTF.en_AU   | Flight Origin Airport           |
      | EXPIE.en_IE | Flight Destinations             |
      | EXPNZ.en_AU | Flight Origin City              |
      | EXPES.es_ES | Hotel Destinations              |
      | EXPFR.fr_FR | Travel Guide Flights            |
      | EXPIT.it_IT | Travel Guide Hotels             |
      | TVLY.en_US  | Travel Guide Airlines           |
      | ORB.en_US   | Destination Travel Guides       |
      | CTIX.en_US  | Flight Ond Airport              |
      | EBUK.en_GB  | Flight Ond City                 |
      | EBCH.de_CH  | Flight Origin Airport           |
      | EBCH.en_GB  | Flight Destinations             |
      | EBCH.fr_CH  | Flight Origin City              |
      | EBFI.fi_FI  | Hotel Destinations              |
      | EBFI.en_GB  | Travel Guide Flights            |
      | EBDE.de_DE  | Travel Guide Hotels             |
      | EBFR.fr_FR  | Travel Guide Airlines           |
      | EBIE.en_IE  | Travel Guide Car Rental Company |
      | EXP.en_US   | Travel Guide Filter Hotels      |
      | MJSE.sv_SE  | Flight Ond Airport              |
      | EXP.en_US   | Url Mapping                     |
      | ORB.en_US   | Car Rental Guide                |
      | CTIX.en_US  | Car Rental Destinations         |
      | EBFR.fr_FR  | Car Rental Guide Airport        |
      | EBCH.fr_CH  | Travel Guide Airports           |
      | EXP.en_US   | Travel Guide Vacation Rentals   |

  Scenario: User logout
    Given I open flex manager
    And I click on the navigation bar userDropdown and click on logout