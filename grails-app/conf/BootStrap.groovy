import com.restolist.*

class BootStrap {

    public static final String MAIN_PLATE = "Plat principal"
    public static final String APPETIZER = "Entree"
    public static final String DESSERT = "Dessert"


    public static final String ASIATIQUE = "asiatique"
    public static final String EUROPEEN = "européen"
    public static final String AMERICAIN = "américain"

    public static final String CHINOIS = "chinois"
    public static final String THAI = "thaïlandais"
    public static final String INDIEN = "indien"
    public static final String VIET = "vietnamien"
    public static final String ITALIEN = "italien"
    public static final String MEXICAIN = "mexicain"
    public static final String LOCAL = "local"


    def init = { servletContext ->

        if (!Role.count){
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

            def testUser = new User(username: 'user', password: 'user').save()
            def adminUser = new User(username: "admin" ,password:"admin").save()

            UserRole.create(testUser,userRole,true)
            UserRole.create(adminUser,adminRole,true)
        }

        if (!Country.count){
            new Country(name: "Suisse").save()
            new Country(name: "France").save()
        }

        if (!RestaurantOverType.count){
            new RestaurantOverType(overType: EUROPEEN).save()
            new RestaurantOverType(overType: ASIATIQUE).save()
            new RestaurantOverType(overType: AMERICAIN).save()
        }

        if (!RestaurantType.count){
            new RestaurantType(type: ITALIEN,restaurantOverType: RestaurantOverType.findByOverType(EUROPEEN)).save()
            new RestaurantType(type: LOCAL,restaurantOverType: RestaurantOverType.findByOverType(EUROPEEN)).save()
            new RestaurantType(type: VIET,restaurantOverType: RestaurantOverType.findByOverType(ASIATIQUE)).save()
            new RestaurantType(type: CHINOIS,restaurantOverType: RestaurantOverType.findByOverType(ASIATIQUE)).save()
            new RestaurantType(type: THAI,restaurantOverType: RestaurantOverType.findByOverType(ASIATIQUE)).save()
            new RestaurantType(type: INDIEN,restaurantOverType: RestaurantOverType.findByOverType(ASIATIQUE)).save()
            new RestaurantType(type: MEXICAIN,restaurantOverType: RestaurantOverType.findByOverType(AMERICAIN)).save()
        }

        if (!Ingredient.count){
            new Ingredient(name: "Tomate").save()
            new Ingredient(name: "Jambon").save()
        }

        if (!SectionType.count){
            new SectionType(type: MAIN_PLATE).save()
            new SectionType(type: APPETIZER).save()
            new SectionType(type: DESSERT).save()
        }

        if (!Restaurant.count){
            def ch = Country.findAllByName("Suisse").get(0)
            def ad0 = new Address(street1: "27, route de Chancy",zipCode: "1213",city: "Petit-Lancy",country: ch).save()
            def ad1 = new Address(street1: "12, route de Genève",zipCode: "1260",city: "Nyon",country: ch).save()
            def ad2 = new Address(street1: "82, avenue d'Echallens",zipCode: "1004",city: "Lausanne",country: ch).save()
            def ad3 = new Address(street1: "2, avenue du Temple",zipCode: "1020",city: "Renens VD",country: ch).save()
            def ad4 = new Address(street1: "11, chemin des Baumettes",zipCode: "1020",city: "Renens VD",country: ch).save()
            def ad5 = new Address(street1: "4, rue de l'Industrie",zipCode: "1030",city: "Bussigny-près-Lausanne",country: ch).save()
            def ad6 = new Address(street1: "5, rue de la Gare",zipCode: "1030",city: "Bussigny-près-Lausanne",country: ch).save()
            def ad7 = new Address(street1: "63, rue de l'Industrie",zipCode: "1030",city: "Bussigny-près-Lausanne",country: ch).save()
            def ad8 = new Address(street1: "16, place Chauderon",zipCode: "1003",city: "Lausanne",country: ch).save()
            def ad9 = new Address(street1: "3, escaliers du Grand-Pont",zipCode: "1003",city: "Lausanne",country: ch).save()
            def ad10 = new Address(street1: "10, rue du Tunnel",zipCode: "1005",city: "Lausanne",country: ch).save()
            def ad11 = new Address(street1: "24, rue du Bugnon",zipCode: "1005",city: "Lausanne",country: ch).save()
            def ad12 = new Address(street1: "282, route de Saint-Julien",zipCode: "1258",city: "Perly",country: ch).save()
            def ad13 = new Address(street1: "278, route de Saint-Julien",zipCode: "1258",city: "Perly",country: ch).save()
            def ad14 = new Address(street1: "34, chemin des Semailles",zipCode: "1212",city: "Grand_Lancy",country: ch).save()
            def ad15 = new Address(street1: "4, place du Rondeau",zipCode: "1227",city: "Carouge",country: ch).save()
            def ad16 = new Address(street1: "11, rue Jacques-Dalphin",zipCode: "1227",city: "Carouge",country: ch).save()
            def ad17 = new Address(street1: "43, boulevard Carl-Vogt",zipCode: "1205",city: "Genève",country: ch).save()
            def ad18 = new Address(street1: "21, avenue de Sainte-Clotilde",zipCode: "1205",city: "Genève",country: ch).save()
            def ad19 = new Address(street1: "25, rue Voltaire",zipCode: "1201",city: "Genève",country: ch).save()

            def r0 = new Restaurant(name: "Le Coral", address: ad0, phoneNumber: "022.793.94.60", type: RestaurantType.findByType(CHINOIS)).save()
            def r1 = new Restaurant(name: "Restaurant de la Plage", address: ad1, phoneNumber: "022.362.61.01", website: "http://www.lerestaurantdelaplage.ch/", type: RestaurantType.findByType(LOCAL)).save()
            def r2 = new Restaurant(name: "L'Indochine", address: ad2, phoneNumber: "021.625.88.88", type: RestaurantType.findByType(VIET)).save()
            def r3 = new Restaurant(name: "La Rose Rouge", address: ad3, phoneNumber: "021.634.58.27", type: RestaurantType.findByType(ITALIEN)).save()
            def r4 = new Restaurant(name: "Le Cacib", address: ad4, phoneNumber: "021.634.34.94", website: "http://www.restaurant-pizzeria.net/", type: RestaurantType.findByType(ITALIEN)).save()
            def r5 = new Restaurant(name: "Les Arcades", address: ad5, phoneNumber: "021.701.59.15", website:"http://www.lesarcades.ch/", type: RestaurantType.findByType(ITALIEN)).save()
            def r6 = new Restaurant(name: "Shanghai Garden", address: ad6, phoneNumber: "021.701.21.08", website:"http://www.shanghaigarden.ch/", type: RestaurantType.findByType(CHINOIS)).save()
            def r7 = new Restaurant(name: "Chez Cavu", address: ad7, phoneNumber: "021.612.82.62", website:"http://www.chezcavu.ch/", type: RestaurantType.findByType(LOCAL)).save()
            def r8 = new Restaurant(name: "Au Canard Pékinois", address: ad8, phoneNumber: "021.329.03.23", website:"http://www.au-canard-pekinois.ch/", type: RestaurantType.findByType(CHINOIS)).save()
            def r9 = new Restaurant(name: "Ma-Jong", address: ad9, phoneNumber: "021.329.05.25", website:"http://www.ma-jong.ch/", type: RestaurantType.findByType(CHINOIS)).save()
            def r10 = new Restaurant(name: "Chez Xu 1", address: ad10, phoneNumber: "021.312.40.87", website:"http://www.ma-jong.ch/", type: RestaurantType.findByType(CHINOIS)).save()
            def r11 = new Restaurant(name: "Sabaidee Thai-Vieng", address: ad11, phoneNumber: "021.544.59.59", website:"http://www.sabaidee-thai-vieng.ch/", type: RestaurantType.findByType(CHINOIS)).save()
            def r12 = new Restaurant(name: "Chez Renato", address: ad12, phoneNumber: "022.771.45.19", type: RestaurantType.findByType(ITALIEN)).save()
            def r13 = new Restaurant(name: "Al Castellino", address: ad13, phoneNumber: "022.771.11.98", website:"http://www.alcastellino.ch/",type: RestaurantType.findByType(ITALIEN)).save()
            def r14 = new Restaurant(name: "Semailles", address: ad14, phoneNumber: "022.794.87.77", type: RestaurantType.findByType(ITALIEN)).save()
            def r15 = new Restaurant(name: "Boccalino", address: ad15, phoneNumber: "022.343.73.87", website:"http://www.restaurant-boccalino.ch",type: RestaurantType.findByType(ITALIEN)).save()
            def r16 = new Restaurant(name: "Le Canard Intelligent", address: ad16, phoneNumber: "022.342.29.73", website:"http://www.canard-intelligent.com/",type: RestaurantType.findByType(CHINOIS)).save()
            def r17 = new Restaurant(name: "Sole Mio", address: ad17, phoneNumber: "022.321.75.07", website:"http://www.solemio-geneve.ch/",type: RestaurantType.findByType(CHINOIS)).save()
            def r18 = new Restaurant(name: "Jaipur", address: ad18, phoneNumber: "022.329.05.04", type: RestaurantType.findByType(INDIEN)).save()
            def r19 = new Restaurant(name: "Chat Rouge", address: ad19, phoneNumber: "022.344.98.98", website: "http://www.lechatrouge.ch/", type: RestaurantType.findByType(MEXICAIN)).save()

            new Opening(restaurant: r0,lundiMidi: false,lundiSoir: false,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: true,dimancheSoir: true).save()
            new Opening(restaurant: r1,lundiMidi: false,lundiSoir: false,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: true,dimancheSoir: true).save()
            new Opening(restaurant: r2,lundiMidi: false,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r3,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r4,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: true,dimancheSoir: true).save()
            new Opening(restaurant: r5,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: false,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r6,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r7,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r8,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r9,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: false,dimancheSoir: true).save()
            new Opening(restaurant: r11,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r13,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r14,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: true,dimancheSoir: true).save()
            new Opening(restaurant: r15,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: true,dimancheSoir: true).save()
            new Opening(restaurant: r16,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: true,dimancheSoir: true).save()
            new Opening(restaurant: r17,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: true,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r18,lundiMidi: true,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: false).save()
            new Opening(restaurant: r19,lundiMidi: false,lundiSoir: true,mardiMidi: true,mardiSoir: true,mercrediMidi: true,mercrediSoir: true,jeudiMidi: true,jeudiSoir: true,vendrediMidi: true,vendrediSoir: true,samediMidi: false,samediSoir: true,dimancheMidi: false,dimancheSoir: true).save()

            def p0 = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r0,priority: 500).save()
            def a0 = new Section(type: SectionType.findByType(APPETIZER),restaurant:r0,priority: 100).save()
            def d0 = new Section(type: SectionType.findByType(DESSERT),restaurant:r0,priority: 1000).save()

            def p1 = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r1,priority: 500).save()
            def a1 = new Section(type: SectionType.findByType(APPETIZER),restaurant:r1,priority: 100).save()
            def d1 = new Section(type: SectionType.findByType(DESSERT),restaurant:r1,priority: 1000).save()

            def p2 = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r2,priority: 500).save()
            def a2 = new Section(type: SectionType.findByType(APPETIZER),restaurant:r2,priority: 100).save()
            def d2 = new Section(type: SectionType.findByType(DESSERT),restaurant:r2,priority: 1000).save()

            def p3 = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r3,priority: 500).save()
            def a3 = new Section(type: SectionType.findByType(APPETIZER),restaurant:r3,priority: 100).save()
            def d3 = new Section(type: SectionType.findByType(DESSERT),restaurant:r3,priority: 1000).save()

            def p4 = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r4,priority: 500).save()
            def a4 = new Section(type: SectionType.findByType(APPETIZER),restaurant:r4,priority: 100).save()
            def d4 = new Section(type: SectionType.findByType(DESSERT),restaurant:r4,priority: 1000).save()

            def p5 = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r5,priority: 500).save()
            def a5 = new Section(type: SectionType.findByType(APPETIZER),restaurant:r5,priority: 100).save()
            def d5 = new Section(type: SectionType.findByType(DESSERT),restaurant:r5,priority: 1000).save()


            new Entry(name: "Rouleaux de Neims", price:12f,section:a0,priority: 1).save()
            new Entry(name: "Ribs de porc rôtis", price:13f,section:a0,priority: 2).save()
            new Entry(name: "Dim Sum", price:17f,section:a0,priority: 3).save()

            new Entry(name: "Porc Szetchuan sauté deux fois", price:27f,section: p0,priority: 101).save()
            new Entry(name: "Boeuf Szetchuan sauté deux fois", price:29f,section:p0,priority: 102).save()
            new Entry(name: "Boeuf à la sauce saté", price:29f,section:p0,priority: 103).save()
            new Entry(name: "Filet de boeuf au gingembre pimenté", price:29f,section:p0,priority: 104).save()
            new Entry(name: "Boeuf piquant sur lit de vermicelles frits", price:30f,section:p0,priority: 105).save()

            new Entry(name: "Beignets de banane, pomme, ananas", price:8.5,section:d0,priority: 1).save()
            new Entry(name: "Litchee au sirop", price:7f,section:d0,priority: 2).save()
            new Entry(name: "Gingembre confit", price:7.5,section:d0,priority: 3).save()


            new Entry(name: "Caviar d'aubergine", price:6f,section:a1,priority: 1).save()
            new Entry(name: "Filet de féra du Léman", price:28f,section:p1,priority: 2).save()
            new Entry(name: "Crème brûlée", price:7f,section:d1,priority: 3).save()


            new Entry(name: "Bun Bo Hue: bouillon à la citronnelle, spaghetti de riz et émincé de boeuf", price:12f,section:a2,priority: 1).save()
            new Entry(name: "Croustillant de bœuf à la sauce d’huître", price:27f,section:p2,priority: 2).save()
            new Entry(name: "Flan d'Indochine au coco", price:8f,section:d2,priority: 3).save()


            new Entry(name: "Carpaccio de filet d'espadon ", price:22f,section:a4,priority: 1).save()
            new Entry(name: "Strozzapreti Vulcano", price:25.50,section:p4,priority: 2).save()
            new Entry(name: "Panna cotta aux fruits des bois", price:10.50,section:d4,priority: 3).save()
        }
    }
    def destroy = {
    }
}
