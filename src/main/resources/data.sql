INSERT INTO artist (name, basic_info) VALUES ('Foster The People', null);
INSERT INTO album (date_created, img_url, name) VALUES ('2014-03-14', 'supermodelcover.jpg', 'Supermodel');
INSERT INTO song (album_id, name, path, duration, album_cover_url) VALUES (1, 'Are You What You Want To Be', '1/AreYouWhatYouWantToBe.mp3', '00:04:30', 'supermodelcover.jpg'),
                                               (1, 'Ask Yourself', '1/AskYourself.mp3', '00:04:23', 'supermodelcover.jpg'),
                                               (1, 'Coming Of Age', '1/ComingOfAge.mp3', '00:04:39', 'supermodelcover.jpg'),
                                               (1, 'Nevermind', '1/Nevermind.mp3', '00:05:18', 'supermodelcover.jpg'),
                                               (1, 'Pseudologia Fantastica', '1/PseudologiaFantastica.mp3', '00:05:31', 'supermodelcover.jpg'),
                                               (1, 'The Angelic Welcome Of Mr. Jones', '1/TheAngelicWelcomeOfMr. Jones.mp3', '00:00:33', 'supermodelcover.jpg'),
                                               (1, 'Best Friend', '1/BestFriend.mp3',  '00:04:27', 'supermodelcover.jpg'),
                                               (1, 'A Beginner''s Guide To Destroying The Moon', '1/ABeginner''sGuideToDestroyingTheMoon.mp3', '00:04:39', 'supermodelcover.jpg'),
                                               (1, 'Goats in Trees', '1/GoatsInTrees.mp3', '00:05:10', 'supermodelcover.jpg'),
                                               (1, 'The Truth', '1/TheTruth.mp3', '00:04:29', 'supermodelcover.jpg'),
                                               (1, 'Fire Escape', '1/FireEscape.mp3', '00:04:21', 'supermodelcover.jpg'),
                                               (1, 'Tabloid Super Junkie', '1/TabloidSuperJunkie.mp3', '00:06:00', 'supermodelcover.jpg');
INSERT INTO album_artist (album_id, artist_id) VALUES (1, 1);
INSERT INTO song_artist (artist_id, song_id) VALUES (1, 1),
                                                    (1, 2),
                                                    (1, 3),
                                                    (1, 4),
                                                    (1, 5),
                                                    (1, 6),
                                                    (1, 7),
                                                    (1, 8),
                                                    (1, 9),
                                                    (1, 10),
                                                    (1, 11),
                                                    (1, 12);