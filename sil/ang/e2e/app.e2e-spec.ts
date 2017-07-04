import { Bookstore } from './app.po';

describe('Bookstore', function() {
  let page: Bookstore;

  beforeEach(() => {
    page = new Bookstore();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
