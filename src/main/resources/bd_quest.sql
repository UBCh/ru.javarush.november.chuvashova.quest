-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Мар 28 2023 г., 12:56
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `ubch`
--

-- --------------------------------------------------------

--
-- Структура таблицы `bd_quest`
--

CREATE TABLE IF NOT EXISTS `bd_quest` (
  `level` text NOT NULL,
  `header` text NOT NULL,
  `prologue` text NOT NULL,
  `levelMax` text NOT NULL,
  `questions` text NOT NULL,
  `answersFail` text NOT NULL,
  `rightButton` text NOT NULL,
  `buttonWong` text NOT NULL,
  `victoryText` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `bd_quest`
--

INSERT INTO `bd_quest` (`level`, `header`, `prologue`, `levelMax`, `questions`, `answersFail`, `rightButton`, `buttonWong`, `victoryText`) VALUES
('1', 'ВЕЛИКАЯ ПИРАМИДА САГИ', 'СТОЙ ИСКАТЕЛЬ ПРИКЛЮЧЕНИЙ!!!!Ты достиг своей цели после долгого пути, пройдя через леса и горы, и руины старых городов, в поисках сокровищ. Теперь ты стоишь перед огромной пирамидой. Вход — прямоугольная дыра в стене — прямо перед тобой.         Вокруг безлюдная пустыня. Сфинкс позади нависает над тобой, его тень от солнца закрывает. Ты идёшь вперёд,ноги увязают в песке, горячий ветер треплет одежду. Ты у входа, тьма впереди закрывает взор...', '3', 'На стене справа выбиты символы древнего языка, они требуют поклониться погребенному здесь богу.', 'Ты вошел без уважения и стены раздавливают тебя.', 'Поклониться', 'К черту суеверия', 'У самурая нет цели, есть только путь. Ты спокойно уходишь. Победа.'),
('2', '', '', '', 'Ты Поклонился!!!. И спокойно проходишь внутрь. Ты достаёшь факел из заплечного мешка. Ты зажигаешь его. Неровный, колеблющийся свет освещает коридор, пол покрыт пылью. Ты идёшь вперёд довольно долгое время, пока не натыкаешься на развилку, вправо и влево, два пути. Что выберешь?', 'Ты пошел направо и натыкаешься на ловушку. Стрелы из стен пронзают тебя.', 'Налево', 'Герои идут направо', ''),
('3', '', '', '', 'Ты пошел налево!!! и спокойно проходишь. Ты долго петляешь по коридорам, избегаешь ловушек (давно сломанных, впрочем), перепрыгиваешь через дыры в полу. Так доходишь до тронного зала. Ты видишь трон вдалеке, на нём полуразложившийся труп восседает, единственное сокровище — богато украшенный скипетр в его руке. Ты доходишь до трона. Ты смотришь на скипетр.\r\n', 'Пытаешься вырвать скипетр. Труп пробуждается и убивает тебя.Ибо воровать не хорошо!!!', 'Просто уходи', 'Хватай добычу', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
