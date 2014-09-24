import com.restolist.*

class BootStrap {

    public static final String MAIN_PLATE = "Plat principal"
    public static final String APPETIZER = "Entree"
    public static final String DESSERT = "Dessert"


    public static final String ASIATIQUE = "asiatique"
    public static final String ITALIEN = "italien"
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

        if (!RestaurantType.count){
            new RestaurantType(type: ITALIEN).save()
            new RestaurantType(type: ASIATIQUE).save()
            new RestaurantType(type: LOCAL).save()
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
            def r0 = new Restaurant(name: "Le Coral", address: ad0, phoneNumber: "022.793.94.60", type: RestaurantType.findByType(ASIATIQUE)).save()
            def r1 = new Restaurant(name: "Restaurant de la Plage", address: ad1, phoneNumber: "022.362.61.01", type: RestaurantType.findByType(LOCAL)).save()
            def r2 = new Restaurant(name: "L'Indochine", address: ad2, phoneNumber: "021.625.88.88", type: RestaurantType.findByType(ASIATIQUE)).save()
            def r3 = new Restaurant(name: "La Rose Rouge", address: ad3, phoneNumber: "021.634.58.27", type: RestaurantType.findByType(ITALIEN)).save()
            def r4 = new Restaurant(name: "Le Cacib", address: ad4, phoneNumber: "021.634.34.94", type: RestaurantType.findByType(ITALIEN)).save()

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
