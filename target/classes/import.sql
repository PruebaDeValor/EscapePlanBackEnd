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
                (11, 'La Saga de las Morgan. Capítulo 0: La Zona', 
                'Sumérgete en un mundo de terror y misterio en el Convento de las Comendadoras.',
                'En "Capítulo 0: La Zona", te adentrarás en el Convento de las Comendadoras para investigar extraños sucesos ocurridos en la vivienda del conserje. La experiencia ofrece una tensión constante desde el inicio, con una ambientación espectacular que te sorprenderá en cada momento. Disponible en dos modalidades: Modo Terror (con actores y sustos) y Modo Tensión (sin actores y con menor nivel de sustos).',
                'Terror;Suspense;Saga de los Morgan;Convento',
                '11.webp',
                5,
                'https://terrorstories.com/madrid/la-zona-escape-room',
                2, 6, 'SI');

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
                'Terror;Suspense;Saga de los Morgan',
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
                'Terror;Slasher;Saga de los Morgan',
                '13.webp',
                6,
                'https://terrorstories.com/madrid/diamante-de-almas-escape-room',
                2, 6, 'SI');






