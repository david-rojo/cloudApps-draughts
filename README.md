<html>
<body class="book">
  <div id="header">
    <h1>¡Bienvenid@ a las Damas!</h1>
    <div class="details">
      <span id="author" class="author"><a href="https://github.com/david-rojo">David Rojo(@david-rojo)</a></span><br>
    </div><br>
    <div id="toc" class="toc">
      <div id="toctitle">Índice</div>
      <ul class="sectlevel1">
        <li><a href="#modelo-del-dominio">Modelo del Dominio</a></li>
        <li><a href="#requisitos">Requisitos</a></li>
        <li><a href="#vista-de-casos-de-uso">Vista de Casos de Uso</a>
          <ul class="sectlevel2">
            <li><a href="#prototipo-de-interfaz">Prototipo de Interfaz</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <div id="content">
    <div class="sect1">
      <h2 id="modelo-del-dominio">Modelo del Dominio</h2>
      <div class="sectionbody">
        <table class="tableblock frame-none grid-none stretch">
          <colgroup>
            <col style="width: 70%;">
            <col style="width: 30%;">
          </colgroup>
          <tbody>
            <tr>
              <td class="tableblock halign-left valign-top">
                <div class="content">
                  <div class="ulist">
                    <ul>
                      <li>
                        <p>Elementos: <strong>dos jugadores</strong>, un <strong>tablero de ajedrez</strong>, con una
                          esquina blanca a la derecha de cada jugador, y <strong>fichas blancas y negras</strong>, para
                          los dos jugadores, <strong>12 peones</strong> y <strong>2 damas</strong></p>
                      </li>
                      <li>
                        <p>En el <strong>estado inicial</strong> de la partida se colocan todas los peones de cada
                          jugador en los <strong>cuadros negros</strong> de las <strong>tres filas más cercanas</strong>
                          a éste, como en la siguiente imagen.</p>
                      </li>
                      <li>
                        <p>Los <strong>jugadores mueven alternativamente</strong> una de sus fichas,
                          <strong>empezando</strong> por el jugador de las fichas <strong>blancas</strong>, de una de
                          las siguientes maneras:</p>
                        <div class="ulist">
                          <ul>
                            <li>
                              <p>un <strong>peón de una casilla puede mover a una de las dos casillas adyacentes en
                                  diagonal y hacia adelante</strong>, si ésta está <strong>vacia</strong></p>
                            </li>
                            <li>
                              <p>un <strong>peón de una casilla puede mover a una de las dos casillas adyacentes de las
                                  adyacentes en diagonal y hacia adelante</strong>, si ésta esta <strong>vacía</strong>
                                y la adyacente está <strong>ocupada por un ficha contraria</strong> repitiendo este
                                mismo movimiento hasta 3 veces desde la nueva casilla. Todas las fichas contrarias
                                "<strong>saltadas</strong>" en este momvimiento se <strong>retiran del tablero</strong>
                              </p>
                            </li>
                            <li>
                              <p>en cualquiera de los dos casos anteriores, si un <strong>peón termina su movimiento en
                                  la última fila del tablero</strong>, se convierte en <strong>dama</strong>.</p>
                            </li>
                            <li>
                              <p>una <strong>dama de una casilla puede mover a una de las casillas diagonales</strong>,
                                si existe como <strong>máximo una ficha contraria</strong>, repitiendo este mismo
                                movimiento hasta 3 veces desde la nueva casilla. Todas las fichas contrarias
                                "<strong>saltadas</strong>" se <strong>retiran del tablero</strong></p>
                            </li>
                          </ul>
                        </div>
                      </li>
                      <li>
                        <p><strong>Pierde el jugador que no puede realizar movimientos</strong>, porque <strong>no se
                            cumplen las condiciones</strong> para el movimiento de todas sus fichas o que ya <strong>no
                            hay fichas</strong> sobre el tablero</p>
                      </li>
                    </ul>
                  </div>
                </div>
              </td>
              <td class="tableblock halign-left valign-top">
                <div class="content">
                  <table class="tableblock frame-none grid-none stretch">
                    <colgroup>
                      <col style="width: 100%;">
                    </colgroup>
                    <tbody>
                      <tr>
                        <td class="tableblock halign-left valign-top">
                          <div class="content">
                            <div class="ulist">
                              <ul>
                                <li>
                                  <p><a href="https://en.wikipedia.org/wiki/Draughts"><strong>Wiki</strong></a></p>
                                </li>
                                <li>
                                  <p><a href="https://www.youtube.com/watch?v=bN8VO8Nt0ws"><strong>Youtube</strong></a>
                                  </p>
                                </li>
                              </ul>
                            </div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td class="tableblock halign-left valign-top">
                          <div class="content">
                            <div class="imageblock">
                              <div class="content">
                                <img src="doc/images/draughtsModeloDominio.svg" alt="draughtsModeloDominio" width="392"
                                  height="607">
                              </div>
                            </div>
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="sect1">
      <h2 id="requisitos">Requisitos</h2>
      <div class="sectionbody">
        <table class="tableblock frame-all grid-all stretch">
          <colgroup>
            <col style="width: 50%;">
            <col style="width: 50%;">
          </colgroup>
          <tbody>
            <tr>
              <td class="tableblock halign-left valign-top">
                <div class="content">
                  <div class="ulist">
                    <ul>
                      <li>
                        <p><em>Funcionalidad: <strong>Básica</strong></em></p>
                      </li>
                      <li>
                        <p><em>Interfaz: <strong>Texto</strong></em></p>
                      </li>
                      <li>
                        <p><em>Distribución: <strong>Standalone</strong></em></p>
                      </li>
                      <li>
                        <p><em>Persistencia: <strong>No</strong></em></p>
                      </li>
                    </ul>
                  </div>
                </div>
              </td>
              <td class="tableblock halign-left valign-top">
                <div class="content">
                  <div class="imageblock">
                    <div class="content">
                      <img src="doc/images/draughts.jpg" alt="draughts" width="400" height="400">
                    </div>
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="sect1">
      <h2 id="vista-de-casos-de-uso">Vista de Casos de Uso</h2>
      <div class="sectionbody">
        <table class="tableblock frame-all grid-all stretch">
          <colgroup>
            <col style="width: 50%;">
            <col style="width: 50%;">
          </colgroup>
          <thead>
            <tr>
              <th class="tableblock halign-left valign-top">Diagrama de Actores y Casos de Uso</th>
              <th class="tableblock halign-left valign-top">Diagrama de Contexto</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="tableblock halign-left valign-top">
                <div class="content">
                  <div class="imageblock">
                    <div class="content">
                      <img src="doc/images/diagramaActoresCasosUso.svg" alt="diagramaActoresCasosUso" width="196"
                        height="247">
                    </div>
                  </div>
                </div>
              </td>
              <td class="tableblock halign-left valign-top">
                <div class="content">
                  <div class="imageblock">
                    <div class="content">
                      <img src="doc/images/diagtamaContexto.svg" alt="diagtamaContexto" width="257" height="606">
                    </div>
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
        <div class="sect2">
          <h3 id="prototipo-de-interfaz">Prototipo de Interfaz</h3>
          <table class="tableblock frame-none grid-nonen stretch">
            <colgroup>
              <col style="width: 50%;">
              <col style="width: 50%;">
            </colgroup>
            <tbody>
              <tr>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="paragraph">
                      <p><strong>Arranque</strong></p>
                    </div>
                  </div>
                </td>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="paragraph">
                      <p><strong>Peón convertido en dama</strong></p>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td class="tableblock halign-left valign-top" rowspan="3">
                  <div class="content">
                    <div class="literalblock">
                      <div class="content">
                        <pre>Las Damas!!!

 12345678
1 n n n n1
2n n n n 2
3 n n n n3
4        4
5        5
6b b b b 6
7 b b b b7
8b b b b 8
 12345678
Mueven las blancas: 61.52

 12345678
1 n n n n1
2n n n n 2
3 n n n n3
4        4
5 b      5
6  b b b 6
7 b b b b7
8b b b b 8
 12345678
Mueven las negras: 32,43

 12345678
1 n n n n1
2n n n n 2
3   n n n3
4  n     4
5 b      5
6  b b b 6
7 b b b b7
8b b b b 8
 12345678
 Mueven las ...</pre>
                      </div>
                    </div>
                  </div>
                </td>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="literalblock">
                      <div class="content">
                        <pre>                    ...

 12345678
1        1
2        2
3 n      3
4n b     4
5        5
6        6
7 b      7
8        8
 12345678
Mueven las negras: 72,83

 12345678
1        1
2        2
3 n      3
4n b     4
5        5
6        6
7        7
8  B     8
 12345678
 Mueven las ...</pre>
                      </div>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="paragraph">
                      <p><strong>Posibles errores</strong></p>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="literalblock">
                      <div class="content">
                        <pre>Error!!! No te entiendo: &lt;d&gt;&lt;d&gt;{,&lt;d&gt;&lt;d&gt;}[0-2]
Error!!! No es una coordenada del tablero
Error!!! No hay ficha que mover
Error!!! No es una de tus fichas
Error!!! No vas en diagonal
Error!!! No está vacío el destino
Error!!! No comes contrarias
Error!!! No se puede comer tantas en un movimiento
Error!!! No avanzas
Error!!! No respetas la distancia
Error!!! No se puede comer tantas en un salto</pre>
                      </div>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="paragraph">
                      <p><strong>Pierden las negras por bloqueo y continuan jugando</strong></p>
                    </div>
                  </div>
                </td>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="paragraph">
                      <p><strong>Pierden las blancas sin fichas y no continuan jugando</strong></p>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="literalblock">
                      <div class="content">
                        <pre> 12345678
1        1
2        2
3        3
4        4
5        5
6        6
7 n      7
8b       8
 12345678
Derrota!!! No puedes mover tus fichas!!!
¿Queréis jugar otra? (s/n): s

Las Damas!!!

 12345678
1 n n n n1
2n n n n 2
3 n n n n3
4        4
5        5
6b b b b 6
7 b b b b7
8b b b b 8
 12345678</pre>
                      </div>
                    </div>
                  </div>
                </td>
                <td class="tableblock halign-left valign-top">
                  <div class="content">
                    <div class="literalblock">
                      <div class="content">
                        <pre> 12345678
1        1
2        2
3        3
4        4
5        5
6  n n   6
7 n      7
8  N     8
 12345678
Derrota!!! No puedes mover tus fichas!!!
¿Queréis jugar otra? (s/n): s</pre>
                      </div>
                    </div>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
