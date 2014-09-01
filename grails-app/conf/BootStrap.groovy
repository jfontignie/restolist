import com.restolist.*

class BootStrap {

    public static final String MAIN_PLATE = "Plat principal"
    public static final String APPETIZER = "Entree"
    public static final String DESSERT = "Dessert"
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
            new RestaurantType(type: "italien").save()
            new RestaurantType(type: "Chinois").save()
            new RestaurantType(type: "francais").save()
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
            def r = new Restaurant(name: "Le Corl",
                    address: new Address(street1: "27, route de Chancy",zipCode: "1213",city: "Petit-Lancy",country: ch),
            phoneNumber: "022.793.94.60").save()

            def p = new Section(type: SectionType.findByType(MAIN_PLATE),restaurant:r,priority: 500).save()
            def a = new Section(type: SectionType.findByType(APPETIZER),restaurant:r,priority: 100).save()
            def d = new Section(type: SectionType.findByType(DESSERT),restaurant:r,priority: 1000).save()

            new Entry(name: "Rouleaux de Neims", price:12f,section:a,priority: 1).save()
            new Entry(name: "Ribs de porc rôtis", price:13f,section:a,priority: 2).save()
            new Entry(name: "Dim Sum", price:17f,section:a,priority: 3).save()

            new Entry(name: "Porc Szetchuan sauté deux fois", price:27f,section: p,priority: 101).save()
            new Entry(name: "Boeuf Szetchuan sauté deux fois", price:29f,section:p,priority: 102).save()
            new Entry(name: "Boeuf à la sauce saté", price:29f,section:p,priority: 103).save()
            new Entry(name: "Filet de boeuf au gingembre pimenté", price:29f,section:p,priority: 104).save()
            new Entry(name: "Boeuf piquant sur lit de vermicelles frits", price:30f,section:p,priority: 105).save()

            new Entry(name: "Beignets de banane, pomme, ananas", price:8.5,section:d,priority: 1).save()
            new Entry(name: "Litchee au sirop", price:7f,section:d,priority: 2).save()
            new Entry(name: "Gingembre config", price:7.5,section:d,priority: 3).save()


        }
    }
    def destroy = {
    }
}
