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
                    google_maps_url
                ) VALUES (
                    1,
                    'Experiencity Colors - Plaza Francisco Morano',
                    'Pl. de Francisco Morano, 3, 28005 Arganzuela, Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://colorsescaperoom.com/madrid/',
                    'https://maps.app.goo.gl/Bf2gmkymDB7iBSLXA'
                );
            -- Escape Rooms Experiencity Colors - Plaza Francisco Morano
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (1, 'Experiencia Perla: Atlantis', 'Encuentra la ciudad perdida de Atlantis.', 'Adéntrate en el océano para encontrar el tesoro atlante. Escape Room de hasta 12 jugadores.', 'Aventura;Océano;Tesoro;Grupos', 'perla-logo.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-perla-escape-room', 2, 12, false),
                (2, 'Experiencia Amarilla', 'Aventura pirata para todos los públicos.', 'La experiencia más grande de Madrid, basada en una de las grandes aventuras de nuestra infancia. ¿Preparados para una aventura pirata?', 'Aventura;Piratas;Familiar;Goonies', 'amarilla-logo.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-amarilla-escape-room', 2, 6, false),
                (3, 'Experiencia Roja', 'Viaja a la Ciudad Prohibida de Pekín.', 'Adéntrate en la antigua China en una experiencia ambientada de película.', 'Aventura;Asia;Histórico;Cultural', 'roja-logo.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-roja-escape-room', 2, 6, false),
                (4, 'Experiencia Azul', 'Vive la acción en las trincheras de la Segunda Guerra Mundial.', 'El mejor Escape Room de acción de Madrid. Una experiencia física e intensa.', 'Acción;Bélico;Intenso;Física', 'azul-logo.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-azul-escape-room', 2, 6, false),
                (5, 'Experiencia Morada', 'Rescata al Dr. Jones en una aventura cinematográfica.', 'Saca tu látigo y ponte el sombrero para rescatar al Dr. Jones. ¡Con un final sorprendente!', 'Aventura;Cine;Exploración;Indiana Jones', 'morada-logo.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-morada-escape-room', 2, 6, false),
                (6, 'Experiencia Verde', 'Escape Room tecnológico sin candados.', 'Ayuda a un misterioso hacker en un desafío altamente tecnológico.', 'Tecnología;Hacker;Moderno;Ingenio', 'verde-logo.webp', 1, 'https://colorsescaperoom.com/madrid/experiencia-verde-escape-room', 2, 6, false);
    
        -- Experiencity Colors - Calle Sambara 94
            -- Localización
                INSERT INTO locations (
                    id,
                    name,
                    address,
                    city,
                    contact_number,
                    website_url,
                    google_maps_url
                ) VALUES (
                    2,
                    'Experiencity Colors - Calle Sambara 94',
                    'Calle Sambara, 94, 28027 Madrid',
                    'Madrid',
                    '+34610424880',
                    'https://colorsescaperoom.com/madrid/',
                    'https://maps.app.goo.gl/eeVYbK4bS1XfSQZV6'
                );
            -- Escape Rooms Experiencity Colors - Calle Sambara 94
                INSERT INTO rooms (
                    id, name, shortDescription, longDescription, theme, imageName, location_id, websiteUrl, minimumCapacity, maximumCapacity, isScary
                ) VALUES
                (7, 'Experiencia Marrón: La mina', 'Adéntrate en una mina sellada y busca el mineral escondido.', 'Recorre todos los recovecos de la mina para encontrar un valioso mineral en sus profundidades. ¡Corred, intrépidos mineros!', 'Aventura;Minería;Ingenio;La mina', 'marron-logo.webp', 2, 'https://colorsescaperoom.com/madrid/experiencia-marron-escape-room', 2, 6, false);


