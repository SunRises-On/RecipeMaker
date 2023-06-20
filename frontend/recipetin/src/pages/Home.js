import React from 'react';
import './styles/HomeStyle.css';
import tin from './resources/recipe-tin.png';

import { Col, Container, Row, Card, Button, Image } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { 
    faPenToSquare, 
    faMotorcycle,
    faFileCirclePlus,
    faHeartCirclePlus
} from '@fortawesome/free-solid-svg-icons';


export default function Home(){
    const image = {tin};
    const imageElement = new Image();
    imageElement.src = image;

    return(
            <Container
            fluid 
            className="min-vh-100 d-flex flex-column p-0"
            >
                <Row
                className="flex-grow-1 g-0"
                >
                    <Col
                    // d-none d-sm-block
                    // hide on screens smaller than lg
                    className="border d-none d-sm-block"
                    lg={3} 
                    >
                        <Container
                        >
                            <Row
                            className="flex-grow-1"
                            >
                                <Col
                                xs={12} lg={12}
                                >
                                    <Container
                                    className = "pt-5"
                                    >
                                        <Row>
                                            <Col
                                            xs={4}
                                            style={{
                                                display:'flex',
                                                alignItems:'center',
                                                justifyContent:'center'
                                            }}
                                            >
                                                <FontAwesomeIcon icon={faPenToSquare}
                                                className='fa-2x'
                                                />
                                            </Col>
                                            <Col
                                            xs={8}
                                            >
                                                <h5>
                                                    Create Recipes
                                                </h5>
                                            </Col>
                                        </Row>
                                    </Container>
                                </Col>
                                <Col
                                xs={12}
                                lg={12}
                                >   
                                    <Container
                                    className = "pt-5"
                                    >
                                        <Row>
                                            <Col
                                            xs={4}
                                            style={{
                                                display:'flex',
                                                alignItems:'center',
                                                justifyContent:'center'
                                            }}
                                            >
                                                <FontAwesomeIcon icon={faMotorcycle}
                                                // fa-2x 
                                                // make icon bigger
                                                className='fa-2x'
                                                />
                                            </Col>
                                            <Col
                                            xs={8}
                                            >
                                                <h5>
                                                    Explore New Recipes
                                                </h5>
                                            </Col>
                                        </Row>
                                    </Container>
                                </Col>
                                <Col
                                xs={12}
                                lg={12}
                                >
                                    <Container
                                    className = "pt-5"
                                    >
                                        <Row>
                                            <Col
                                            xs={4}
                                            style={{
                                                display:'flex',
                                                alignItems:'center',
                                                justifyContent:'center'
                                            }}
                                            >
                                                <FontAwesomeIcon icon={faFileCirclePlus}
                                                className='fa-2x'
                                                />
                                            </Col>
                                            <Col
                                            xs={8}
                                            >
                                                <h5>
                                                    Make Different Cuisine
                                                </h5>
                                            </Col>
                                        </Row>
                                    </Container>
                                </Col>
                                <Col
                                xs={12}
                                lg={12}
                                >
                                    <Container
                                    className = "pt-5"
                                    >
                                        <Row>
                                            <Col
                                            xs={4}
                                            style={{
                                                display:'flex',
                                                alignItems:'center',
                                                justifyContent:'center'
                                            }}
                                            >
                                                <FontAwesomeIcon icon={faHeartCirclePlus}
                                                className='fa-2x'
                                                />
                                            </Col>
                                            <Col
                                            xs={8}
                                            >
                                                <h5>
                                                    Save Your Favorites
                                                </h5>
                                            </Col>
                                        </Row>
                                    </Container>
                                </Col>
                            </Row>
                        </Container>
                    </Col>
                    <Col
                    className="border"
                    style={{backgroundColor:"whitesmoke",
                            }}
                    xs={12} lg={9}
                    >
                        <Container 
                        className = 'mx-auto mt-5'
                        >
                            <h1
                            style={{fontFamily: "Luminari"}}
                            >
                                Create your own family recipe box.
                            </h1>
                            <br/>
                            <h3
                            style={{fontFamily:"Luminari"}}
                            >
                                <em>
                                    "With an easy UI upload within seconds."
                                </em>
                            </h3>
                            <br/>
                            <Card style={{width: '20rem' ,backgroundColor: 'whitesmoke', border: 'none'}}
                            className="mx-auto my-auto p5"
                            >
                                <Card.Img variant='top'
                                className="shadow"
                                style={{backgroundColor:'none'}}
                                src={tin}
                                />
                                <Card.Body>
                                    <Button 
                                    className = "btn-lg shadow-sm"
                                    variant="secondary"
                                    href='/create'
                                    >
                                    Enter
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Container>
                    </Col>
                </Row>
            </Container>

    );
}