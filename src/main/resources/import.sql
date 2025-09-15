     --E
        -- Experiencity Francisco Morano
            -- Localización
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    1,
                    'Experiencity Colors - Plaza Francisco Morano',
                    'Pl. de Francisco Morano, 3, 28005 Arganzuela, Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://colorsescaperoom.com/madrid/',
                    'https://maps.app.goo.gl/Bf2gmkymDB7iBSLXA',
                    '40.404859, -3.716383'
                );
            -- Escape Rooms Experiencity Colors - Plaza Francisco Morano
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (1, 'Experiencia Perla: Atlantis', 'Encuentra la ciudad perdida de Atlantis.', 'Adéntrate en el océano para encontrar el tesoro atlante. Escape Room de hasta 12 jugadores.', 'Aventura;Océano;Tesoro;Grupos', '1.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-perla-escape-room', 2, 12, 'NO'),
                (2, 'Experiencia Amarilla', 'Aventura pirata para todos los públicos.', 'La experiencia más grande de Madrid, basada en una de las grandes aventuras de nuestra infancia. ¿Preparados para una aventura pirata?', 'Aventura;Piratas;Familiar;Goonies', '2.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-amarilla-escape-room', 2, 6, 'NO'),
                (3, 'Experiencia Roja', 'Viaja a la Ciudad Prohibida de Pekín.', 'Adéntrate en la antigua China en una experiencia ambientada de película.', 'Aventura;Asia;Histórico;Cultural', '3.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-roja-escape-room', 2, 6, 'NO'),
                (4, 'Experiencia Azul', 'Vive la acción en las trincheras de la Segunda Guerra Mundial.', 'El mejor Escape Room de acción de Madrid. Una experiencia física e intensa.', 'Acción;Bélico;Intenso;Física', '4.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-azul-escape-room', 2, 6, 'NO'),
                (5, 'Experiencia Morada', 'Rescata al Dr. Jones en una aventura cinematográfica.', 'Saca tu látigo y ponte el sombrero para rescatar al Dr. Jones. ¡Con un final sorprendente!', 'Aventura;Cine;Exploración;Indiana Jones', '5.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-morada-escape-room', 2, 6, 'NO'),
                (6, 'Experiencia Verde', 'Escape Room tecnológico sin candados.', 'Ayuda a un misterioso hacker en un desafío altamente tecnológico.', 'Tecnología;Hacker;Moderno;Ingenio', '6.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-verde-escape-room', 2, 6, 'NO');
        -- Experiencity Colors - Calle Sambara 94
            -- Localización
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    2,
                    'Experiencity Colors - Calle Sambara 94',
                    'Calle Sambara, 94, 28027 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://colorsescaperoom.com/madrid/',
                    'https://maps.app.goo.gl/eeVYbK4bS1XfSQZV6',
                    '40.436141, -3.645696'
                );
            -- Escape Rooms Experiencity Colors - Calle Sambara 94
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (7, 'Experiencia Marrón: La mina', 'Adéntrate en una mina sellada y busca el mineral escondido.', 'Recorre todos los recovecos de la mina para encontrar un valioso mineral en sus profundidades. ¡Corred, intrépidos mineros!', 'Aventura;Minería;Ingenio;La mina', '7.webp', 2, 'https://colorsescaperoom.com/madrid/experiencia-marron-escape-room', 2, 6, 'NO');

            -- Escape Rooms Experiencity Colors - Calle Cobos de Segovia 20
                -- Localización
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    3,
                    'Experiencity Colors - Calle Cobos de Segovia 20',
                    'Calle Cobos de Segovia, 20, 28005 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://colorsescaperoom.com/madrid/',
                    'https://maps.app.goo.gl/cbbRizaPKMDxgk1N9',
                    '40.405526115388156, -3.7191543513933083'
                );

                -- Escape Rooms Experiencity Colors - Calle Cobos de Segovia 20
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (8, 'Experiencia Dorada: Desmadre en Las Vegas', 
                'El escape room más divertido en el que no pararás ni un segundo.', 
                'Desmadre en Las Vegas es una experiencia original para hasta 7 jugadores y 80 minutos donde encontrarás juegos de habilidad, lógica y pruebas muy alocadas. Ambiente festivo, humor garantizado, ideal para despedidas o planes con amigos.', 
                'Humor;Fiesta;Divertido;Las Vegas', 
                '8.webp', 
                3, 
                'https://colorsescaperoom.com/madrid/experiencia-dorada-escape-room', 
                2, 7, 'NO');

            --Experiencity Colors - Calle Sambara 116
                -- Localización para Experiencias en Calle Sambara 116
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    4,
                    'Experiencity Colors - Calle Sambara 116',
                    'Calle Sambara, 116, 28027 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://colorsescaperoom.com/madrid/',
                    'https://maps.app.goo.gl/w1AkpeZwzHHSiL9eA',
                    '40.4367199761288, -3.6444450044171917'
                );

                -- Escape Room Experiencia Rosa en Calle Sambara 116
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (9, 'Experiencia Rosa: Luz Verde',
                'Competición única donde solo uno ganará el premio mayor.',
                'La Experiencia Rosa: Luz Verde es un escape room altamente competitivo para hasta 6 jugadores durante 70 minutos. Incluye minijuegos inspirados en juegos populares, pruebas físicas moderadas y muchos guiños a series. Solo uno podrá alzarse con el premio.',  
                'Juego del calamar;Juegos;Desafío;Competitivo',  
                '9.webp',  
                4,  
                'https://colorsescaperoom.com/madrid/experiencia-rosa-escape-room',  
                2, 6, 'NO');

                -- Escape Room Experiencia Naranja en Calle Sambara 116
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (10, 'Experiencia Naranja: Aladino',
                'Viaja a Allabah en busca de la lámpara maravillosa.',
                'La Experiencia Naranja: Aladino es una aventura inmersiva por hasta 7 jugadores y 90 minutos. Estancias ambientadas, efectos especiales, ambientación rica en detalles, ambientado en el cuento clásico del ladrón más famoso de Oriente.',  
                'Aventura;Aladin;Cuento;Fantástico',  
                '10.webp',  
                4,  
                'https://colorsescaperoom.com/madrid/experiencia-naranja-escape-room',  
                2, 7, 'NO');

            --Experiencity Terror Stories - Plaza de las Comendadoras    
                -- Localización para Terror Stories by Experiencity - Plaza de las Comendadoras
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    5,
                    'Experiencity Terror Stories - Plaza de las Comendadoras',
                    'Plaza de las Comendadoras, s/n, 28015 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://terrorstories.com/madrid',
                    'https://maps.app.goo.gl/rkHNcaNCrmUyYows8',
                    '40.42729791372909, -3.7092338804268628'
                );

                -- Escape Room La Saga de las Morgan. Capítulo 0: La Zona en Plaza de las Comendadoras
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (11, 'La Saga de los Morgan. Capítulo 0: La Zona', 
                'Sumérgete en un mundo de terror y misterio en el Convento de las Comendadoras.',
                'En "Capítulo 0: La Zona", te adentrarás en el Convento de las Comendadoras para investigar extraños sucesos ocurridos en la vivienda del conserje. La experiencia ofrece una tensión constante desde el inicio, con una ambientación espectacular que te sorprenderá en cada momento. Disponible en dos modalidades: Modo Terror (con actores y sustos) y Modo Tensión (sin actores y con menor nivel de sustos).',
                'Terror;Suspense;Saga;Saga de los Morgan',
                '11.webp',
                5,
                'https://terrorstories.com/madrid/la-zona-escape-room',
                2, 6, 'SI');

            -- Experiencity Terror Stories - Calle Sambara 116
                -- Localización para Experiencity Terror Stories - Calle Sambara 116
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    6,
                    'Experiencity Terror Stories - Calle Sambara 116',
                    'Calle de Sambara, 116, 28027 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://terrorstories.com/madrid',
                    'https://maps.app.goo.gl/QDFpFvysCVpwu5tW9',
                    '40.43677470186653, -3.644490009391094'
                );

                -- Escape Room La Saga de los Morgan. Capítulo 1: La Oscuridad en Calle Sambara 116
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (12, 'La Saga de los Morgan. Capítulo 1: La Oscuridad',
                'Ayuda a Marcelo Morgan a enfrentarse a una presencia demoníaca en su hogar.',
                'Han pasado 15 años desde el trágico suceso en el Convento donde me crié. Juré venganza y no pararé hasta acabar con ese maldito demonio. Mi amada esposa Margaret... No hay día que no recuerde a nuestra preciosa hija, Sambara Morgan. Pero he sacrificado mucho en esta desigual lucha. Jamás me perdonaré el haberla perdido, él no para de atormentarnos con ello.',
                'Terror;Suspense;Saga;Saga de los Morgan',
                '12.webp',
                6,
                'https://terrorstories.com/madrid/la-oscuridad-escape-room',
                2, 7, 'SI');

                -- Escape Room La Saga de los Morgan. Capítulo 2: Diamante de Almas en Calle Sambara 116
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (13, 'La Saga de los Morgan. Capítulo 2: Diamante de Almas',
                'El último capítulo de la Saga de los Morgan, lleno de tensión y adrenalina.',
                'La Saga de los Morgan llega a su fin con este último capítulo. Alon Morgan organiza su exposición de diamantes en la ciudad, pero necesita vuestra ayuda. Escenas impactantes, mecánicas intensas y secretos familiares pondrán a prueba vuestra astucia y coraje. Una experiencia de hasta 6 jugadores con tres modos de juego: Terror, Tensión e Investigación.',
                'Terror;Slasher;Saga;Saga de los Morgan',
                '13.webp',
                6,
                'https://terrorstories.com/madrid/diamante-de-almas-escape-room',
                2, 6, 'SI');

            -- Experiencity Terror Stories - Calle Marcelino Camacho 3
                -- Localización para Experiencity Terror Stories - Calle Marcelino Camacho 3
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    7,
                    'Experiencity Terror Stories - Calle Marcelino Camacho 3',
                    'P.º de Marcelino Camacho, 3, Carabanchel, 28025 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://terrorstories.com/madrid',
                    'https://maps.app.goo.gl/H6HAXir8fTiHJ9pM8',
                    '40.384865, -3.739978'
                );

                -- Escape Room La Saga del Tarot. Primera Tirada : El Loco
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (14, 'La Saga del Tarot. Primera Tirada : El Loco',
                'Ayuda a Mateo y Amanda a descubrir los secretos de la casa Turmet.',
                'En "La Primera Tirada: El Loco", recibiréis una misteriosa invitación a El Complejo Turmet, una casa de más de 70 años llena de secretos familiares y sucesos paranormales. Ayuda a Mateo y Amanda a desentrañar el pasado de su familia mientras exploráis habitaciones llenas de enigmas, llantos y oscuridad. Experiencia para hasta 6 jugadores y 70 minutos, disponible en modos Terror y Tensión.',
                'Terror;Saga;Saga del Tarot;Tarot',
                '14.webp',
                7,
                'https://terrorstories.com/madrid/el-loco-escape-room',
                2, 6, 'SI');

                -- Escape Room La Saga del Tarot. Segunda Tirada : El Juicio
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (15, 'La Saga del Tarot. Segunda Tirada : El Juicio',
                'Ayuda a Amanda y Tristán a descubrir el paradero de Daniel en el Complejo Turmet.',
                'En "La Segunda Tirada: El Juicio", tras la desaparición de Daniel y años de investigación, Amanda y Tristán abren nuevas zonas del Complejo Turmet para encontrar pistas. Explora la antigua tienda de reliquias, enfrenta energías negativas y resuelve enigmas que revelarán los secretos del pasado. Experiencia para hasta 6 jugadores y 70 minutos, con modos Terror y Tensión.',
                'Terror;Saga;Saga del Tarot;Tarot',
                '15.webp',
                7,
                'https://terrorstories.com/madrid/el-juicio-escape-room',
                2, 6, 'SI');

            -- Experiencity La Orden
                -- Localización para Experiencity La Orden
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    8,
                    'Experiencity La Orden',
                    'C. de Tomás Borrás, 10, Arganzuela, 28045 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://www.laordenescape.com',
                    'https://maps.app.goo.gl/QBZP8jTHEhE3qSyXA',
                    '40.395298, -3.697509'
                );

                -- Escape Room Jack el Destripador en Calle Tomás Borrás 10
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    16,
                    'Jack el Destripador',
                    'De los mejores escape room de terror en Madrid. Revive la historia de Jack el Destripador.',
                    'En 1888, en el barrio londinense de Whitechapel, ocurrieron una serie de asesinatos cometidos por Jack el Destripador. Ahora podréis resolver todas las incógnitas en una experiencia de terror con diferentes niveles de miedo. Ingenio, colaboración y todos los sentidos alerta serán clave para sobrevivir a una noche con Jack el Destripador. Modalidad terror, tensión o investigación disponibles.',
                    'Terror;Jack el Destripador;Asesino;Londres',
                    '16.webp',
                    8,
                    'https://laordenescape.com/experiencia-jack-el-destripador-escape-room',
                    2,
                    7,
                    'YES'
                );
            

                -- Escape Room El Yeti en Calle Tomás Borrás 10
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    17,
                    'El Yeti',
                    'Aventura trepidante en el Himalaya. ¡Súbete al helicóptero!',
                    'Tú y tu grupo de exploradores os embarcáis en una expedición al Himalaya. Tras un accidente en helicóptero, debéis sobrevivir y descubrir los secretos de una cabaña misteriosa. ¿Serán esos zapatos demasiado grandes para un humano? Disfruta de una experiencia dinámica, con dos niveles de dificultad y sorpresas en cada rincón.',
                    'Aventura;Himalaya;Exploración;Dinámica',
                    '17.webp',
                    8,
                    'https://laordenescape.com/experiencia-yeti-escape-room',
                    2,
                    7,
                    'NO'
                );

                -- Escape Room Magallanes
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    18,
                    'Magallanes',
                    'El Hall Escape más divertido y misterioso de La Orden.',
                    'Un juego de aventuras en el que reina el misterio por saber qué pasó con el famoso Fernando de Magallanes. Apto para todos los públicos, con versión KIDS para niños. Descubre el canal, la expedición y el enigma de las especias en Filipinas, acompañado de una tripulación peculiar y enigmática. Ideal para fomentar el trabajo en equipo y la diversión en familia o con amigos.',
                    'Aventura;Hall Escape;Exploración;Familia',
                    '18.webp',
                    8,
                    'https://laordenescape.com/experiencia-magallanes-escape-room',
                    2,
                    6,
                    'NO'
                );

                -- Escape Room Kennedy
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    19,
                    'Kennedy Misión SWAT',
                    'Escape room de acción trepidante: pon a prueba tu mente y tus habilidades físicas.',
                    'El Presidente Kennedy lidera el Proyecto X, una organización que busca ocultar los grandes secretos de la historia. La Orden envía un equipo para asesinarlo, pero la CIA ha desplegado un dispositivo especial para proteger la caravana presidencial. Vive una experiencia frenética, física y estratégica, llena de adrenalina y acción. ¿Conseguirás acabar con el Proyecto X?',
                    'Acción;Intensa;Kennedy;CIA',
                    '19.webp',
                    8,
                    'https://laordenescape.com/experiencia-kennedy-escape-room',
                    2,
                    6,
                    'NO'
                );

                -- Escape Room Hipólita
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    20,
                    'Hipólita',
                    'Un escape room de mitología y amazonas con una de las estancias más originales de Madrid.',
                    'Hace siglos reinó la amazona Hipólita, hija de Ares y poseedora de un cinturón mágico. Las leyendas cuentan que Heracles intentó arrebatárselo, pero la verdadera historia esconde un desafío aún mayor. Rompe el bucle de espacio y tiempo en el que está atrapada y ayuda a Hipólita a recuperar su cinturón. Apto para todos los públicos, con versión KIDS y final adaptable.',
                    'Mitología;Amazonas;Aventuras;Familiar',
                    '20.webp',
                    8,
                    'https://laordenescape.com/experiencia-hipolita-escape-room',
                    2,
                    6,
                    'NO'
                );

                -- Hall Escape Baco
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    21,
                    'Baco',
                    'Escape room cooperativo y competitivo para grupos grandes inspirado en la mitología del dios del vino.',
                    'En la antigüedad, las tabernas de Baco y Dionisio eran famosas en el Mediterráneo. Tras la desaparición de Baco, Dionisio recuperó la fama con su vino, pero generaciones después se ha hallado el lugar donde Baco creaba sus vinos. ¿Seréis capaces de sacar la verdad a la luz? Un hall escape cooperativo y competitivo para hasta 20 jugadores, ideal para team building y celebraciones.',
                    'Mitología;Hall Escape;Grupos;Familiar',
                    '21.webp',
                    8,
                    'https://laordenescape.com/experiencia-baco-escape-room',
                    4,
                    20,
                    'NO'
                );

                -- Escape Room Reina Roja
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES (
                    22,
                    'Reina Roja',
                    'El primer escape room con modo batalla de Experiencity, ambientado en la cultura Maya.',
                    'Año 1994. El Doctor Arnoldo González y su hija Cris investigan el yacimiento Maya de Palenque. Tras un accidente, descubren la cámara funeraria de La Reina Roja. Ayuda a Cris a rescatar a su padre y escapa de la maldición. Sala espejo para competir por equipos o modo cooperativo para grupos pequeños. ¿Quién será el primero en escapar?',
                    'Maya;Grupos;Competitiva;Sala Espejo',
                    '22.webp',
                    8,
                    'https://laordenescape.com/experiencia-reina-roja-escape-room',
                    2,
                    8,
                    'NO'
                );
            -- Experiencity The City
                -- Localización para Experiencity The City
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url,
                    latitude_and_longitude_string
                ) VALUES (
                    9,
                    'Experiencity The City',
                    'C. de San Cayetano, 3B, Local, Centro, 28005 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://thecityescaperoom.com/madrid',
                    'https://maps.app.goo.gl/u7DrCkR3jwh7XeCw6',
                    '40.409539, -3.706359'
                );
                
                    -- Escape Room La Lavandería en Experiencity The City
                    INSERT INTO rooms (
                        id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                    ) VALUES (
                        23,
                        'La Lavandería',
                        'Escape room de roleplay y humor para grupos grandes.',
                        'La Lavandería es un escape room con un componente de role play que enriquece la experiencia y consigue un clímax de diversión que no olvidarás. Convertíos en maestros del disfraz y haceos pasar por trabajadores de La Lavandería más turbia de The City para descubrir qué oculta su trastienda. Tenéis dos objetivos: descubrir quiénes son los tres socios principales de Parker y, por otro, encontrar la Lunalina y robársela sin que se entere su encargada Mel. Duración: 80 minutos. Ideal para grupos y familias que quieran reír y participar en interpretación.',
                        'Humor;Roleo;Grupos;Familiar',
                        '23.webp',
                        9,
                        'https://thecityescaperoom.com/madrid/la-lavanderia-escape-room',
                        2,
                        10,
                        'NO'
                    );
                
                    -- Escape Room Ciudad de Vacaciones en Experiencity The City
                    INSERT INTO rooms (
                        id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                    ) VALUES (
                        24,
                        'Ciudad de Vacaciones',
                        'Meta escape room paródico y familiar, divertido y rejugable.',
                        'Ciudad de Vacaciones es un escape room dentro de un escape room: un meta escape room paródico con ambientación sorprendente y mucho humor. Tendréis que colaros en el antiguo escape room de la ciudad para encontrar el libro de cuentas de Parker y ayudar a la organización Procyon. Requiere algo de habilidad física en algún momento. Duración: 75 minutos. Ideal para familias y grupos de amigos.',
                        'Humor;Roleo;Aventura;Familiar',
                        '24.webp',
                        9,
                        'https://thecityescaperoom.com/madrid/ciudad-de-vacaciones-escape-room',
                        2,
                        7,
                        'NO'
                    );
                
                    -- Escape Room Clínica Lihte en Experiencity The City
                    INSERT INTO rooms (
                        id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                    ) VALUES (
                        25,
                        'Clínica Lihte',
                        'Hall escape para grupos grandes con versión KIDS y experiencia cooperativa.',
                        'Clínica Lihte: Virus es un escape room pensado para grupos grandes donde deberéis acceder al laboratorio secreto y desarrollar el antídoto antes de ser descubiertos. Experiencia cooperativa en la que os dividirán en equipos dentro del mismo espacio; incluye una cuenta atrás intensa y un personaje cómico que acompaña la partida. Versión KIDS disponible adaptada para niños. Duración: 70 minutos.',
                        'Humor;Roleo;Familiar;Hall Escape',
                        '25.webp',
                        9,
                        'https://thecityescaperoom.com/madrid/clinica-lihte-escape-room',
                        6,
                        20,
                        'NO'
                    );

                    -- Escape Room La Nevera Show en Experiencity The City
                    INSERT INTO rooms (
                        id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                    ) VALUES (
                        26,
                        'La Nevera Show',
                        'Concurso de televisión paródico y competitivo, ideal para parejas y grupos pequeños.',
                        'La Nevera Show es un escape room original y desenfadado donde seréis la estrella de un concurso de televisión. Compite con tus contrincantes y pon a prueba tus habilidades: uno podrá ser millonario y el resto quedará congelado. Parte del juego se desarrolla en un espacio reducido similar a un ascensor; pensado para parejas o grupos pequeños. Duración: 75 minutos.',
                        'Humor;Roleo;Parejas;Competitiva',
                        '26.webp',
                        9,
                        'https://thecityescaperoom.com/madrid/la-nevera-show-escape-room',
                        2,
                        4,
                        'NO'
                    );

                    