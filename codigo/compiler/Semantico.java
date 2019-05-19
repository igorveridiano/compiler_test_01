package compiler;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class Semantico implements Constants {

	Stack stack = new Stack();

	ArrayList<Id> lista_ids = new ArrayList<Id>();

	Verificador verificador = new Verificador();

	public int getResult() {
		return ((Integer) stack.peek()).intValue();
	}

	public void executeAction(int action, Token token) throws SemanticError {

		Id id = new Id();
		Integer a = null, b = null;
		String c;
		boolean adicao, subtracao, multiplicacao, divisao;

		switch (action) {
		case 1:

			break;

		case 2:

			break;

		case 3:

		case 4:
			c = (String) stack.pop();
			if (verificador.ehInteiro(c)) {
				a = Integer.valueOf(c);
				c = (String) stack.pop();
				if (lista_ids.size() > 0) {
					boolean teste = true;
					for (Id ids : lista_ids) {
						if (ids.getId().equals(c)) {
							ids.setId(c);
							ids.setValue(a);
							ids.setTem_valor(true);
							stack.push(c);
							teste = false;
						}
					}

					if (teste) {
						id.setId(c);
						id.setValue(a);
						id.setTem_valor(true);
						lista_ids.add(id);
						stack.push(c);
					}

				} else {
					id.setId(c);
					id.setValue(a);
					id.setTem_valor(true);
					lista_ids.add(id);
					stack.push(c);
				}

			} else {
				boolean teste = true;
				if (lista_ids.size() > 0) {
					for (Id ids : lista_ids) {
						if (ids.getId().equals(c)) {
							Id aux = ids;
							c = (String) stack.pop();
							for (Id ids_aux : lista_ids) {
								if (ids_aux.getId().equals(c)) {
									ids_aux.setId(c);
									ids_aux.setValue(0);
									ids_aux.setTem_valor(false);
									ids_aux.setId_outro(aux);
									stack.push(c);
									teste = false;
								}
							}

							if (teste) {
								id.setId(c);
								id.setId_outro(aux);
								id.setTem_valor(false);
								lista_ids.add(id);
								stack.push(c);
							}

						}
					}

				} else {
					System.out.print("erro, não existe dois ids para poder setar um ao outro");
				}
			}
			break;

		case 5:
			c = (String) stack.pop();
			if (verificador.ehInteiro(c)) {
				System.out.print(c);
			} else {
				for (Id ids : lista_ids) {
					if (ids.getId().equals(c)) {
						System.out.print(ids.getnext(ids));
					}
				}
			}

			break;

		case 6:
			c = (String) stack.pop();

			if (verificador.ehInteiro(c)) {
				a = Integer.valueOf(c);

				c = (String) stack.pop();

				if (verificador.ehInteiro(c)) {
					b = Integer.valueOf(c);

					stack.push(Integer.toString((b + a)));
				} else {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							b = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						stack.push(Integer.toString((b + a)));
					}
				}
			} else {
				if (lista_ids.size() > 0) {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							a = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						c = (String) stack.pop();
						if (verificador.ehInteiro(c)) {
							b = Integer.valueOf(c);

							stack.push(Integer.toString((b + a)));
						} else {
							teste = false;
							for (Id ids : lista_ids) {
								if (ids.id.equals(c)) {
									b = ids.getnext(id);
									teste = true;
								}
							}
							if (teste) {
								stack.push(Integer.toString((b + a)));
							}
						}
					}

				} else {
					System.out.println("erro, não existem ids para poder se calcular");
				}

			}

			break;

		case 7:
			c = (String) stack.pop();

			if (verificador.ehInteiro(c)) {
				a = Integer.valueOf(c);

				c = (String) stack.pop();

				if (verificador.ehInteiro(c)) {
					b = Integer.valueOf(c);

					stack.push(Integer.toString((b - a)));
				} else {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							b = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						stack.push(Integer.toString((b - a)));
					}
				}
			} else {
				if (lista_ids.size() > 0) {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							a = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						c = (String) stack.pop();
						if (verificador.ehInteiro(c)) {
							b = Integer.valueOf(c);

							stack.push(Integer.toString((b - a)));
						} else {
							teste = false;
							for (Id ids : lista_ids) {
								if (ids.id.equals(c)) {
									b = ids.getnext(id);
									teste = true;
								}
							}
							if (teste) {
								stack.push(Integer.toString((b - a)));
							}
						}
					}

				} else {
					System.out.println("erro, não existem ids para poder se calcular");
				}

			}

			break;

		case 8:

			break;

		case 9:
			c = (String) stack.pop();

			if (verificador.ehInteiro(c)) {
				a = Integer.valueOf(c);

				c = (String) stack.pop();

				if (verificador.ehInteiro(c)) {
					b = Integer.valueOf(c);

					stack.push(Integer.toString((b * a)));
				} else {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							b = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						stack.push(Integer.toString((b * a)));
					}
				}
			} else {
				if (lista_ids.size() > 0) {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							a = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						c = (String) stack.pop();
						if (verificador.ehInteiro(c)) {
							b = Integer.valueOf(c);

							stack.push(Integer.toString((b * a)));
						} else {
							teste = false;
							for (Id ids : lista_ids) {
								if (ids.id.equals(c)) {
									b = ids.getnext(id);
									teste = true;
								}
							}
							if (teste) {
								stack.push(Integer.toString((b * a)));
							}
						}
					}

				} else {
					System.out.println("erro, não existem ids para poder se calcular");
				}

			}

			break;

		case 10:
			c = (String) stack.pop();

			if (verificador.ehInteiro(c)) {
				a = Integer.valueOf(c);

				c = (String) stack.pop();

				if (verificador.ehInteiro(c)) {
					b = Integer.valueOf(c);

					stack.push(Integer.toString((b / a)));
				} else {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							b = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						stack.push(Integer.toString((b / a)));
					}
				}
			} else {
				if (lista_ids.size() > 0) {
					boolean teste = false;
					for (Id ids : lista_ids) {
						if (ids.id.equals(c)) {
							a = ids.getnext(id);
							teste = true;
						}
					}
					if (teste) {
						c = (String) stack.pop();
						if (verificador.ehInteiro(c)) {
							b = Integer.valueOf(c);

							stack.push(Integer.toString((b / a)));
						} else {
							teste = false;
							for (Id ids : lista_ids) {
								if (ids.id.equals(c)) {
									b = ids.getnext(id);
									teste = true;
								}
							}
							if (teste) {
								stack.push(Integer.toString((b / a)));
							}
						}
					}

				} else {
					System.out.println("erro, não existem ids para poder se calcular");
				}

			}
			break;

		case 11:

			break;

		case 12:
			break;

		case 13:
			c = token.getLexeme().toString();

			stack.push(c);

			break;

		case 14:
			c = token.getLexeme().toString();

			if (c.charAt(0) == '0')
				throw new SemanticError("Números começados por 0 não são permitidos", token.getPosition());

			stack.push(c);

			break;

		case 15:
			c = token.getLexeme().toString();

			stack.push(c);

			break;

		}

	}
}
